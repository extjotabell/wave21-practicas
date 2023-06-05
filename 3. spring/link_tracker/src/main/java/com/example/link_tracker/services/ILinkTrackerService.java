package com.example.link_tracker.services;

import com.example.link_tracker.dto.request.LinkTrackerRequestDto;
import com.example.link_tracker.dto.request.LinkTrackerRequestIdDto;
import com.example.link_tracker.dto.response.LinkTrackerResponseUrlDto;

import java.util.List;
import java.util.UUID;

public interface ILinkTrackerService {

    UUID createLinkTracker(LinkTrackerRequestDto linkTrackerDto);
    List<LinkTrackerResponseUrlDto> getAll();


}
