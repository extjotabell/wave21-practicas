package com.mercadolibre.redireclinks.service;

import com.mercadolibre.redireclinks.dto.RedirectURLDTO;
import com.mercadolibre.redireclinks.dto.request.LinkRequestDTO;
import com.mercadolibre.redireclinks.dto.response.LinkRedirectStadisticsDTO;
import com.mercadolibre.redireclinks.dto.response.LinkResponseDTO;
import com.mercadolibre.redireclinks.model.Link;
import com.mercadolibre.redireclinks.repository.LinkRepository;
import com.mercadolibre.redireclinks.util.Mapper;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    public LinkResponseDTO addNewLink(LinkRequestDTO linkRequestDTO){
        linkRepository.addLink(Mapper.getLinkFromLinkRequestDTO(linkRequestDTO));
    }

    public LinkRedirectStadisticsDTO getMetrics(int linkId){
        Link link = linkRepository.findLinkById(linkId);
        LinkRedirectStadisticsDTO metric = new LinkRedirectStadisticsDTO(link.getRedirectCount());
        return metric;
    }

    public RedirectURLDTO getRedirectedUrl(int linkId){
        Link link = linkRepository.findLinkById(linkId);
        //Anexar query param, password, a la redireccion

        return Mapper.getRedirectURLDTOFromURL(linkRepository.getRedirectUrl(password));
    }

}
