package com.example.link_tracker.controllers;

import com.example.link_tracker.dto.request.LinkTrackerRequestDto;
import com.example.link_tracker.dto.request.LinkTrackerRequestIdDto;
import com.example.link_tracker.dto.request.LinkTrackerRequestIdPassword;
import com.example.link_tracker.dto.response.LinkTrackerResponseDto;
import com.example.link_tracker.dto.response.LinkTrackerResponseUrlDto;
import com.example.link_tracker.services.ILinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class LinkTrackerController {

    ILinkTrackerService _linkTrackerService;

    public LinkTrackerController(ILinkTrackerService linkTrackerService) {
        this._linkTrackerService = linkTrackerService;
    }

    @PostMapping("/link")
    public ResponseEntity<UUID> createLinkTracker(@RequestBody LinkTrackerRequestDto linkTrackerDto) {
        return new ResponseEntity<>(_linkTrackerService.createLinkTracker(linkTrackerDto),HttpStatus.OK);
    }

    @GetMapping("/links")
    public ResponseEntity<List<LinkTrackerResponseUrlDto>> getAll() {
        return new ResponseEntity<>(_linkTrackerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<String> redirect(
            @PathVariable("linkId") String linkId,
            @RequestParam("password") String password ) {
        return new ResponseEntity<>(_linkTrackerService.redirectById(new LinkTrackerRequestIdPassword(linkId,password)),HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkTrackerResponseDto> metrics(@PathVariable String linkId) {
        return new ResponseEntity<>(_linkTrackerService.getVisited(new LinkTrackerRequestIdDto(linkId)),HttpStatus.OK);
    }

    @PutMapping("/invalidate/{linkId}")
    public String invalidate(@PathVariable String linkId) {
        return _linkTrackerService.invalidate(new LinkTrackerRequestIdDto(linkId));
    }

}
