package com.example.link_tracker.services;

import com.example.link_tracker.dto.request.LinkTrackerRequestDto;
import com.example.link_tracker.dto.response.LinkTrackerResponseUrlDto;
import com.example.link_tracker.entities.LinkTracker;
import com.example.link_tracker.repositories.ILinkTrackerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkTrackerService implements ILinkTrackerService {


    ILinkTrackerRepository _linkTrackerRepository;
    ModelMapper _mapper;

    public LinkTrackerService(ILinkTrackerRepository linkTrackerRepository) {
        this._linkTrackerRepository = linkTrackerRepository;
        _mapper = new ModelMapper();
    }

    @Override
    public UUID createLinkTracker(LinkTrackerRequestDto linkTrackerDto) {
        LinkTracker linkTracker = new LinkTracker(linkTrackerDto.getUrl(), linkTrackerDto.getPassword());
        return _linkTrackerRepository.createLinkTracker(linkTracker);
    }

    @Override
    public List<LinkTrackerResponseUrlDto> getAll() {
        return _linkTrackerRepository.getAll().stream().map(link -> _mapper.map(link,LinkTrackerResponseUrlDto.class)).toList();
    }


}
