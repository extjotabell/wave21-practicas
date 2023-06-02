package com.mercadolibre.redireclinks.util;

import com.mercadolibre.redireclinks.dto.RedirectURLDTO;
import com.mercadolibre.redireclinks.dto.request.LinkRequestDTO;
import com.mercadolibre.redireclinks.dto.response.LinkRedirectStadisticsDTO;
import com.mercadolibre.redireclinks.model.Link;

public class Mapper {

    public static Link getLinkFromLinkRequestDTO(LinkRequestDTO requestDTO){
        Link link = new Link();
        link.setOriginalUrl(requestDTO.getOriginalUrl());
        link.setPassword(requestDTO.getPassword());
        return link;
    }

    public static LinkRedirectStadisticsDTO DtofromLink(Link link){
        return new LinkRedirectStadisticsDTO(link.getRedirectCount());
    }

    public static RedirectURLDTO getRedirectURLDTOFromURL(String url){
        return new RedirectURLDTO(url);
    }

}
