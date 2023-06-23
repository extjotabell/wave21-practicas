package com.example.recapitulando_spring_P2_VIVO.service;

import com.example.recapitulando_spring_P2_VIVO.dto.request.LinkTrackerRequestDTO;
import com.example.recapitulando_spring_P2_VIVO.dto.response.LinkTrackerResponseDTO;
import com.example.recapitulando_spring_P2_VIVO.entity.LinkTracker;
import com.example.recapitulando_spring_P2_VIVO.entity.MetricsLink;
import com.example.recapitulando_spring_P2_VIVO.exception.BadRequestException;
import com.example.recapitulando_spring_P2_VIVO.exception.NotFoundException;
import com.example.recapitulando_spring_P2_VIVO.repository.ILinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService{

    @Autowired
    ILinkTrackerRepository repository;

    @Override
    public LinkTrackerResponseDTO create(LinkTrackerRequestDTO linkTrackerRequestDTO) {
        Boolean linkExiste = repository.getLinkByName(linkTrackerRequestDTO.getLink());
        if (linkExiste) {
            throw new BadRequestException("El link ya existe");
        }
        LinkTracker linkTracker = new LinkTracker(
                linkTrackerRequestDTO.getLink()
        );
        Integer linkId= repository.save(linkTracker);
        return new LinkTrackerResponseDTO(
                linkId
        );
    }

    @Override
    public String findLinkById(Integer linkId) {
        String linkName = repository.getLinkById(linkId).getLink();
        if (linkName == null) {
            throw new NotFoundException("Link no encontrado");
        }
        repository.saveMetricsByLink(linkId, linkName, 1);
        return linkName;
    }

    @Override
    public Boolean findLinkByName(String linkName) {
        return repository.getLinkByName(linkName);
    }

    @Override
    public Long getMetricsByLink(Integer linkId) {
        return repository.getMetricsByLink(linkId);

    }

    @Override
    public Boolean deleteLink(Integer linkId) {
        return repository.deleteLink(linkId);
    }


}
