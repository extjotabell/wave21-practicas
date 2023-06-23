package com.example.recapitulando_spring_P2_VIVO.repository;

import com.example.recapitulando_spring_P2_VIVO.entity.LinkTracker;
import com.example.recapitulando_spring_P2_VIVO.entity.MetricsLink;

import java.util.List;

public interface ILinkTrackerRepository {

    Integer save(LinkTracker linkTracker);
    LinkTracker getLinkById(Integer linkId);
    Boolean getLinkByName(String linkName);
    MetricsLink saveMetricsByLink(Integer linkId, String linkName, Integer count);
    Long getMetricsByLink(Integer linkId);

    Boolean deleteLink(Integer linkId);
}
