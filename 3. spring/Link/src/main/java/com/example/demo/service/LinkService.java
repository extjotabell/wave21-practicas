package com.example.demo.service;

import com.example.demo.dto.LinkDTOCreate;
import com.example.demo.dto.LinkDTOId;
import com.example.demo.dto.LinkDTORequest;
import com.example.demo.model.Link;
import com.example.demo.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LinkService  implements  ILinkService{

    @Autowired
    ILinkRepository repository;

    public LinkDTOId save(LinkDTOCreate linkDTO){
        Link link = new Link(repository.getId(),linkDTO.getUrl(),linkDTO.getPassword());
        repository.save(link);
        LinkDTOId linkDTOId = new LinkDTOId(link.getId());
        return linkDTOId;
    }

    @Override
    public String getById(LinkDTORequest linkdtorequest) {
        return repository.getById(linkdtorequest).getLink();
    }

}
