package com.example.link_tracker.services;

import com.example.link_tracker.dto.request.LinkTrackerRequestDto;
import com.example.link_tracker.dto.request.LinkTrackerRequestIdDto;
import com.example.link_tracker.dto.request.LinkTrackerRequestIdPassword;
import com.example.link_tracker.dto.response.LinkTrackerResponseDto;
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

    @Override
    public String redirectById(LinkTrackerRequestIdPassword linkTrackerDto) {
        boolean redirect = _linkTrackerRepository.isLinkTrackerRedirectById(UUID.fromString(linkTrackerDto.getId()), linkTrackerDto.getPassword());
        //System.out.println(redirect);
        if (redirect){
            _linkTrackerRepository.addVisited(UUID.fromString(linkTrackerDto.getId()));
            return "Redireccionando..";
        }
        else return "No se pudo redireccionar";
    }

    @Override
    public LinkTrackerResponseDto getVisited(LinkTrackerRequestIdDto linkTrackerDto) {
        return new LinkTrackerResponseDto(_linkTrackerRepository.getVisited(UUID.fromString(linkTrackerDto.getId())));
    }

    @Override
    public String invalidate(LinkTrackerRequestIdDto linkTrackerDto) {
        return _linkTrackerRepository.invalidateLink(UUID.fromString(linkTrackerDto.getId()))?"Link invalidado":"Link no encontrado";
    }

}
