package com.mercadolibre.redireclinks.controller;

import com.mercadolibre.redireclinks.dto.response.LinkRedirectStadisticsDTO;
import com.mercadolibre.redireclinks.dto.response.LinkResponseDTO;
import com.mercadolibre.redireclinks.dto.RedirectURLDTO;
import com.mercadolibre.redireclinks.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO> addNewLink(@RequestBody LinkResponseDTO linkDTO){
        return ResponseEntity.ok(linkService.addNewLink(linkDTO));
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectToUrl(@RequestParam String password){
        RedirectURLDTO urlDTO = linkService.getRedirectedUrl(password);
        return new RedirectView(urlDTO.getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkRedirectStadisticsDTO> getMetrics(@PathVariable int linkId){
        return ResponseEntity.ok(linkService.getMetrics(linkId));
    }

    /*@PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidarLink(@PathVariable int linkId) {
        try {
            linkService.invalidarLink(linkId);
            return ResponseEntity.noContent().build();
        } catch (LinkInvalidException e) {
            return ResponseEntity.notFound().build();
        }
    }*/

    @PutMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidarLink(@PathVariable int linkId){
        linkService.invalidarLink(linkId);
        return ResponseEntity.noContent().build();
    }

}
