package com.example.recapitulando_spring_P2_VIVO.controller;

import com.example.recapitulando_spring_P2_VIVO.dto.request.LinkTrackerRequestDTO;
import com.example.recapitulando_spring_P2_VIVO.dto.response.LinkTrackerResponseDTO;
import com.example.recapitulando_spring_P2_VIVO.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;

@RestController
public class LinkTrackerController {

    @Autowired
    ILinkTrackerService service;

    @PostMapping("link")
    ResponseEntity<LinkTrackerResponseDTO> createLink(@RequestBody LinkTrackerRequestDTO linkTrackerRequestDTO) {
        LinkTrackerResponseDTO linkTrackerResponseDTO = service.create(linkTrackerRequestDTO);
        return new ResponseEntity<>(linkTrackerResponseDTO, HttpStatus.OK);
    }

    @GetMapping("link/{linkId}")
    ResponseEntity<?> redirectLink(@PathVariable Integer linkId) {
        String linkName = service.findLinkById(linkId);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(linkName));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("link/metrics/{linkId}")
    ResponseEntity<?> createMetrics(@PathVariable Integer linkId) {
        Long count = service.getMetricsByLink(linkId);
        return new ResponseEntity<>("Metricas: " + count, HttpStatus.OK);
    }

    @PostMapping("link/invalidate/{linkId}")
    ResponseEntity<?> deleteLink(@PathVariable Integer linkId) {
        Boolean borrado = service.deleteLink(linkId);
        if (borrado) {
            return new ResponseEntity<>("Link Borrado ", HttpStatus.OK);
        }
        return new ResponseEntity<>("El link no existe ", HttpStatus.OK);

    }
}
