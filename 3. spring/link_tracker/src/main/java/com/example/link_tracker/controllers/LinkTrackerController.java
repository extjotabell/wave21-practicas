package com.example.link_tracker.controllers;

import com.example.link_tracker.dto.request.LinkTrackerRequestDto;
import com.example.link_tracker.dto.response.LinkTrackerResponseUrlDto;
import com.example.link_tracker.services.ILinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class LinkTrackerController {

    ILinkTrackerService _linkTrackerService;

    public LinkTrackerController(ILinkTrackerService linkTrackerService) {
        this._linkTrackerService = linkTrackerService;
    }

    @PostMapping("/link")
    public UUID createLinkTracker(@RequestBody LinkTrackerRequestDto linkTrackerDto) {
        return _linkTrackerService.createLinkTracker(linkTrackerDto);
    }

    @GetMapping("/links")
    public ResponseEntity<List<LinkTrackerResponseUrlDto>> getAll() {
        return new ResponseEntity<>(_linkTrackerService.getAll(), HttpStatus.OK);
    }
}
