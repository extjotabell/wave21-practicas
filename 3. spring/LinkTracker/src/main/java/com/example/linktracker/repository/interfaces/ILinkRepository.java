package com.example.linktracker.repository.interfaces;

import com.example.linktracker.dto.LinkDto;
import com.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILinkRepository {
    void create(Link link);
    Optional<Link> getLinkById(Long id);
    void invalidateLink(Long id);

    Integer getMetrics(Long id);

    Link addLink(String link, String password);
}
