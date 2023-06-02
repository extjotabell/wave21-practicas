package com.bootcamp.redirectenvivo.service;

import com.bootcamp.redirectenvivo.dto.request.LinkRequestDTO;
import com.bootcamp.redirectenvivo.dto.response.LinkDTO;
import com.bootcamp.redirectenvivo.dto.response.LinkIdResponseDTO;
import com.bootcamp.redirectenvivo.dto.response.LinkResponseMaskDTO;
import com.bootcamp.redirectenvivo.dto.response.MetricsResponseDTO;
import com.bootcamp.redirectenvivo.exceptions.LinkNotFoundException;
import com.bootcamp.redirectenvivo.exceptions.LinkPasswordException;
import com.bootcamp.redirectenvivo.model.Link;
import com.bootcamp.redirectenvivo.repository.LinkRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkService implements LinkServiceInterface {

    @Autowired
    LinkRepositoryInterface linkRepository;


    @Override
    public LinkIdResponseDTO createLink(LinkRequestDTO linkDTO) {
        Link link = new Link();
        link.setUrl(linkDTO.getUrl());
        link.setIsActive(linkDTO.getIsActive());
        link.setPassword(linkDTO.getPassword());
        Link responseRepository = linkRepository.createLink(link);
        LinkIdResponseDTO linkIdResponseDTO = new LinkIdResponseDTO(responseRepository.getLinkId());

        return linkIdResponseDTO;
    }

    @Override
    public List<LinkDTO> getAll() {
        List<LinkDTO> result = new ArrayList<>();
        linkRepository.getAll().forEach(link -> {
            LinkDTO linkDTO = new LinkDTO(link.getLinkId(), link.getUrl(), link.getIsActive(), link.getCounter());
            result.add(linkDTO);
        });
        return result;
    }

    @Override
    public LinkResponseMaskDTO getMaskUrl(int linkId, String password) {
        Link link = linkRepository.getLinkById(linkId, password);
        if(link == null){
            throw new LinkNotFoundException(String.format("Link %s is not exist or it's inactive", linkId));
        } else if (link.getLinkId() == -1) {
            throw new LinkPasswordException(String.format("Invalid password to Link %s", linkId));
        }
        return new LinkResponseMaskDTO(String.format("redirect:%s",link.getUrl()));
    }

    @Override
    public MetricsResponseDTO getMetricsById(int linkId) {
        Link link = linkRepository.getLinkById(linkId);
        if(link == null){
            return null;
        }
        return new MetricsResponseDTO(link.getUrl(),link.getCounter());
    }

    @Override
    public String invalidate(int linkId) {
        Link link = linkRepository.invalidate(linkId);
        if(link == null){
            throw new LinkNotFoundException(String.format("Link %s not found", linkId));
        }
        return String.format("Link %s is already inactive", linkId);
    }
}
