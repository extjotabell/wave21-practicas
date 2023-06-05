package com.example.linktracker.controller;

import com.example.linktracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {
    private LinkService service;

    public LinkController(LinkService linkService){
        this.service = linkService;
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable Long linkId){
         return ResponseEntity.ok(service.getMetrics(linkId));
    }

    @PutMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Long linkId) {
        service.invalidateLink(linkId);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/create/{link}")
    public ResponseEntity<?> addLink(@PathVariable String link, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addLink(link, password));
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectLink(@PathVariable Long linkId) {
        return new RedirectView(service.redirectLink(linkId));
    }


}
