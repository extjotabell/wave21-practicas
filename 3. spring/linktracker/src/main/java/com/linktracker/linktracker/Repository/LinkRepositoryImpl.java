package com.linktracker.linktracker.Repository;

import com.linktracker.linktracker.Entity.LinkEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    private final List<LinkEntity> links;
    private final AtomicInteger idGenerator;

    public LinkRepositoryImpl(){
        this.links = new ArrayList<>();
        this.idGenerator = new AtomicInteger();
    }
    @Override
    public LinkEntity save(LinkEntity link) {
        link.setLinkId(idGenerator.incrementAndGet());
        link.setUrl("http://localhost:8080/link/" + link.getLinkId());
        link.setIsInvalid(false);
        link.setRedirectCount(0);
        this.links.add(link);
        return link;
    }

    @Override
    public LinkEntity getById(Integer id) {
        return this.links.stream().filter(link -> link.getLinkId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void delete(Integer id) {
        this.links.removeIf(link -> link.getLinkId().equals(id));
    }

    @Override
    public void update(LinkEntity link) {
        this.links.stream().filter(link1 -> link1.getLinkId().equals(link.getLinkId()))
                .findFirst()
                .ifPresent(linkForEdit -> linkForEdit = link);
    }
}
