package com.bootcamp.redirectenvivo.controller;

import com.bootcamp.redirectenvivo.dto.request.LinkRequestDTO;
import com.bootcamp.redirectenvivo.model.Link;
import com.bootcamp.redirectenvivo.repository.LinkRepository;
import com.bootcamp.redirectenvivo.service.LinkService;
import com.bootcamp.redirectenvivo.service.LinkServiceInterface;
import jdk.dynalink.linker.LinkRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class RedirectController {

    @Autowired
    LinkServiceInterface linkService;

    @PostMapping()
    public ResponseEntity<?> createLink(@RequestBody LinkRequestDTO link) {

        return new ResponseEntity<>(linkService.createLink(link), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<>(linkService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<?> getMaskUrl(@PathVariable int linkId, @RequestParam String password) {

        return new ResponseEntity<>(linkService.getMaskUrl(linkId, password), HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetricsById(@PathVariable int linkId) {

        return new ResponseEntity<>(linkService.getMetricsById(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate")
    public ResponseEntity<?> invalidate(@RequestParam int linkId) {

        return new ResponseEntity<>(linkService.invalidate(linkId), HttpStatus.OK);
    }
}
