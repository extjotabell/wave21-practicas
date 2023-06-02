package com.example.linktracker.service;

import com.example.linktracker.dto.LinkDto;
import com.example.linktracker.dto.MetricsDTO;

public interface LinkService {
    LinkDto getLinkById(Long id);

    void invalidateLink(Long id);

    MetricsDTO getMetrics(Long id);

    LinkDto addLink(String link, String password);
}
