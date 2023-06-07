package com.linktracker.linktracker.Controller;

import com.linktracker.linktracker.DTO.LinkRequestDto;
import com.linktracker.linktracker.DTO.LinkResponseDto;
import com.linktracker.linktracker.DTO.LinkResponseSaveDto;
import com.linktracker.linktracker.Service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {
    private ILinkService _service;

    public LinkController(ILinkService service){
        this._service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkResponseSaveDto> save(@RequestBody LinkRequestDto link){
        return new ResponseEntity<>(this._service.save(link), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirectLink(@PathVariable Integer linkId, @RequestParam String password) {
        LinkResponseDto response = this._service.redirect(linkId);
        if(response != null && !response.getIsInvalid() && response.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create(response.getMaskedUrl())).build();
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<String> quantityRedirections(@PathVariable Integer linkId){
        return new ResponseEntity<>("Cantidad de veces redireccionadas: "+
                this._service.getById(linkId).getRedirectCount(), HttpStatus.OK);
    }
    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<String> inactivelink(@PathVariable Integer linkId){
        this._service.inactivelink(linkId);
        return new ResponseEntity<>("Link invalidado correctamente", HttpStatus.OK);
    }

}
