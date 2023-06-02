package com.bootcamp.redirectenvivo.service;

import com.bootcamp.redirectenvivo.dto.request.LinkRequestDTO;
import com.bootcamp.redirectenvivo.dto.response.LinkDTO;
import com.bootcamp.redirectenvivo.dto.response.LinkIdResponseDTO;
import com.bootcamp.redirectenvivo.dto.response.LinkResponseMaskDTO;
import com.bootcamp.redirectenvivo.dto.response.MetricsResponseDTO;
import com.bootcamp.redirectenvivo.model.Link;

import java.util.List;

public interface LinkServiceInterface {
    LinkIdResponseDTO createLink(LinkRequestDTO link);

    List<LinkDTO> getAll();

    LinkResponseMaskDTO getMaskUrl(int linkId, String password);

    MetricsResponseDTO getMetricsById(int linkId);

    String invalidate(int linkId);
}
