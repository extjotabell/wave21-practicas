package com.example.link_tracker.repositories;

import com.example.link_tracker.entities.LinkTracker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository{

    List<LinkTracker> links;

    public LinkTrackerRepository() {
        this.links = new ArrayList<LinkTracker>();
    }

    public UUID createLinkTracker(LinkTracker linkTracker) {
        links.add(linkTracker);
        return linkTracker.getId();
    }

    public boolean isLinkTrackerRedirectById(UUID id, String password) {
        return links.stream().anyMatch(link -> link.getId().equals(id) && link.getPassword().equals(password) && link.getValid());
    }

    public boolean invalidateLink(UUID id){
        boolean exist = links.stream().anyMatch(link -> link.getId().equals(id));
        if(exist){
            links.stream().filter(link -> link.getId().equals(id)).findFirst().get().setValid(false);
        }
        return exist;

    }

    public List<LinkTracker> getAll(){
        return this.links;
    }

    @Override
    public Integer getVisited(UUID id) {
        return links.stream().filter(link -> link.getId().equals(id)).findFirst().get().getVisited();
    }

    @Override
    public void addVisited(UUID id) {
        links.stream().filter(link -> link.getId().equals(id)).findFirst().get().setVisited(links.stream().filter(link -> link.getId().equals(id)).findFirst().get().getVisited()+1);
    }

}
