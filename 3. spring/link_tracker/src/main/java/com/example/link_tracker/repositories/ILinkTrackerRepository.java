package com.example.link_tracker.repositories;

import com.example.link_tracker.entities.LinkTracker;

import java.util.List;
import java.util.UUID;

public interface ILinkTrackerRepository {

    UUID createLinkTracker(LinkTracker linkTracker);
    boolean isLinkTrackerRedirectById(UUID id, String password);
    boolean invalidateLink(UUID id);
    List<LinkTracker> getAll();
    Integer getVisited(UUID id);
    void addVisited(UUID id);

}
