package com.example.recapitulando_spring_P2_VIVO.repository;

import com.example.recapitulando_spring_P2_VIVO.entity.LinkTracker;
import com.example.recapitulando_spring_P2_VIVO.entity.MetricsLink;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class LinkTrackerRepositoryImpl implements ILinkTrackerRepository{

    List<LinkTracker> linkTrackerList = new ArrayList<>();
    List<MetricsLink> metricsLinkList = new ArrayList<>();

    @Override
    public Integer save(LinkTracker linkTracker) {
        linkTrackerList.add(linkTracker);
        return linkTrackerList.indexOf(linkTracker);
    }

    @Override
    public LinkTracker getLinkById(Integer linkId) {
        if (linkTrackerList.size() <= linkId) {
            return null;
        }
        return linkTrackerList.get(linkId);
    }
    @Override
    public Boolean getLinkByName(String linkName) {
        LinkTracker linkexiste = linkTrackerList.stream()
                .filter(n -> n.getLink().equals(linkName))
                .findFirst()
                .orElse(null);
        if (linkexiste != null) {
            return true;
        };
        return false;
    }

    @Override
    public MetricsLink saveMetricsByLink(Integer linkId, String linkName, Integer count) {
        MetricsLink metricsLink = new MetricsLink(linkId, linkName, count);
        metricsLinkList.add(metricsLink);
        return metricsLink;
    }

    @Override
    public Long getMetricsByLink(Integer linkId) {
        return metricsLinkList.stream()
                .filter(n -> n.getLinkId().equals(linkId))
                .count();
    }

    @Override
    public Boolean deleteLink(Integer linkId) {
        LinkTracker link = getLinkById(linkId);
        return linkTrackerList.remove(link);
    }
}
