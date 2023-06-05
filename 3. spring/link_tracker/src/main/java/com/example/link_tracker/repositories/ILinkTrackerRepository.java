package com.example.link_tracker.repositories;

import com.example.link_tracker.entities.LinkTracker;

import java.util.List;
import java.util.UUID;

public interface ILinkTrackerRepository {

    UUID createLinkTracker(LinkTracker linkTracker);
    Boolean isLinkTrackerRedirectById(UUID id, String password);
    Boolean invalidateLink(UUID id);
    List<LinkTracker> getAll();

}
