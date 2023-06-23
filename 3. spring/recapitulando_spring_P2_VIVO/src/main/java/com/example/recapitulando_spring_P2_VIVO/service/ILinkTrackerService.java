package com.example.recapitulando_spring_P2_VIVO.service;

import com.example.recapitulando_spring_P2_VIVO.dto.request.LinkTrackerRequestDTO;
import com.example.recapitulando_spring_P2_VIVO.dto.response.LinkTrackerResponseDTO;
import com.example.recapitulando_spring_P2_VIVO.entity.LinkTracker;

public interface ILinkTrackerService {

    LinkTrackerResponseDTO create(LinkTrackerRequestDTO linkTrackerRequestDTO);

    String findLinkById(Integer linkId);

    Boolean findLinkByName(String linkName);

    Long getMetricsByLink(Integer linkId);

    Boolean deleteLink(Integer linkId);
}
