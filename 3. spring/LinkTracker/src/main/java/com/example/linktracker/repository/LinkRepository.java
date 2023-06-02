package com.example.linktracker.repository;

import com.example.linktracker.dto.LinkDto;
import com.example.linktracker.exception.InvalidLinkException;
import com.example.linktracker.model.Link;
import com.example.linktracker.repository.interfaces.ILinkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LinkRepository implements ILinkRepository {
    private List<Link> links = new ArrayList<>();

    Long id= 0L;

    @Override
    public void create(Link link){
        links.add(link);
    }

    @Override
    public Optional<Link> getLinkById(Long id){
        return links.stream()
                .filter(link -> link.getId().equals(id))
                .findFirst();
    }

    @Override
    public void invalidateLink(Long id){
        Optional<Link> link = getLinkById(id);
        if(link.isEmpty()) throw new InvalidLinkException("No existe ningun link con el id: " + id);

        link.get().setStatus(Boolean.FALSE);
    }

    @Override
    public Integer getMetrics(Long id){
        Link responseLink = links.stream()
                .filter(link -> link.getId().equals(id))
                .findFirst().orElse(null);
        return responseLink == null? null : responseLink.getCount();
    }

    @Override
    public Link addLink(String link, String password) {
        id++;
        Link linkToAdd= new Link(id,link,0,true);
        return null;
    }

}
