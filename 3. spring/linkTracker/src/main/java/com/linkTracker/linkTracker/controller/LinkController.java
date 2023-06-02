package com.linkTracker.linkTracker.controller;

import com.linkTracker.linkTracker.dto.LinkDTO;
import com.linkTracker.linkTracker.dto.ResponseDTO;
import com.linkTracker.linkTracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {
    //Crear un link: Endpoint POST para crear link a partir de una URL válida
    // y tiene que devolver un JSON con el linkId para utilizar en la redirección.

    LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/crearLink")
    public ResponseEntity<ResponseDTO> createLink(@RequestBody LinkDTO dto){
        return new ResponseEntity<>(linkService.save(dto), HttpStatus.OK);
    }

    //Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que
    // realizar un redirect a la URL enmascarada. Siempre y cuando el link sea válido. En
    // el caso de que el link sea invalido devolver 404(INVESTIGAR REDIRECT)
    @GetMapping("/{linkId}")
    public RedirectView redirectToLink(@PathVariable int linkId){
        RedirectView linkVerified =  linkService.redirectToLink(linkId);
        //urlToRedirect.setUrl(linkService.redirectToLink(linkId));

        return linkVerified;
    }



}
