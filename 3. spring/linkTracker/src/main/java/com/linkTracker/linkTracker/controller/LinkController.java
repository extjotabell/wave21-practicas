package com.linkTracker.linkTracker.controller;

import com.linkTracker.linkTracker.dto.ContadorDTO;
import com.linkTracker.linkTracker.dto.LinkDTO;
import com.linkTracker.linkTracker.dto.ResponseDTO;
import com.linkTracker.linkTracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    //Crear un link: Endpoint POST para crear link a partir de una URL válida
    // y tiene que devolver un JSON con el linkId para utilizar en la redirección.

    LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<ResponseDTO> createLink(@RequestParam String contrasena, @RequestBody LinkDTO dto){
        return new ResponseEntity<>(linkService.save(contrasena, dto), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectToLink(@RequestParam String contrasena, @PathVariable int linkId){
        RedirectView linkVerified =  linkService.redirectToLink(contrasena, linkId);
        //urlToRedirect.setUrl(linkService.redirectToLink(linkId));

        return linkVerified;
    }

    @GetMapping("/metrics/{linkId}")
    public ContadorDTO metricaPorLink(@PathVariable int linkId){
        return linkService.contarRedirecciones(linkId);
    }

    @DeleteMapping("/invalidate/{linkID}")
    public void invalidateLink(@PathVariable int linkID){
        linkService.delete(linkID);
    }

}
