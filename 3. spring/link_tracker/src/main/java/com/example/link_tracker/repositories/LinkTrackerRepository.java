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

    public Boolean isLinkTrackerRedirectById(UUID id, String password) {
        return null;
    }

    public Boolean invalidateLink(UUID id){
        return null;
    }

    public List<LinkTracker> getAll(){
        return this.links;
    }

}
