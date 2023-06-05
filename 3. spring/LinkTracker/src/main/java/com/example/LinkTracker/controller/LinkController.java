package com.example.LinkTracker.controller;

import com.example.LinkTracker.dto.LinkDTO;
import com.example.LinkTracker.dto.LinkIdDTO;
import com.example.LinkTracker.dto.LinkRedirectsDTO;
import com.example.LinkTracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkIdDTO> getLink(final LinkDTO link) {
        LinkIdDTO id = linkService.createLink(link);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<?> redirect(@PathVariable final Integer id, @RequestParam final String passsword) {
        String link = linkService.getLink(id, passsword);
        linkService.countRedirects(id);

        return ResponseEntity.status(HttpStatus.OK).body("redirect:" + link);
        // TODO redirect
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkRedirectsDTO> metrics(@PathVariable final Integer id) {
        LinkRedirectsDTO r = linkService.getMetrics(id);

        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<LinkIdDTO> invalidateLink(final Integer linkID) {
        LinkIdDTO id = linkService.invalidateLink(linkID);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
