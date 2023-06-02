package com.linkTracker.linkTracker.service;

import com.linkTracker.linkTracker.dto.LinkDTO;
import com.linkTracker.linkTracker.dto.ResponseDTO;
import com.linkTracker.linkTracker.exception.LinkNotFoundException;
import com.linkTracker.linkTracker.model.Link;
import com.linkTracker.linkTracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class LinkService {
    @Autowired
    LinkRepository repository;

    public ResponseDTO save(LinkDTO dto){
        Link model = new Link(dto.getUrl(), (int) (Math.random()*25+1));
        ResponseDTO result = new ResponseDTO();
        if (repository.saveLink(model)){
            result.setLinkId(model.getId());
        }
        return result;
    }

    public RedirectView redirectToLink(int linkId){
        Link result = repository.findById(linkId);
        if( result == null){
            throw new LinkNotFoundException("Id invalido");
        }
        LinkDTO linkFromClient = new LinkDTO(result.getUrl(), linkId);
        RedirectView urlToRedirect = new RedirectView();
        urlToRedirect.setUrl(linkFromClient.getUrl());
        return urlToRedirect;
    }
}
