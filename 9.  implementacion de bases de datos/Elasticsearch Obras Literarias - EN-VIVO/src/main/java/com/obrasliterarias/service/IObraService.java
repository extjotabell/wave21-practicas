package com.obrasliterarias.service;

import com.obrasliterarias.model.dto.ObraDTO;

import java.util.List;

public interface IObraService {
    List<ObraDTO> getAllObras();
    ObraDTO createObra(ObraDTO obraDTO);

    List<ObraDTO> autorParam(String autor);

    List<ObraDTO> containsTitle(String title);

    List<ObraDTO> obrasPagesGreaterThanParam(Integer cantidad);

    List<ObraDTO> obrasYearGreaterThanParam(Integer year);

    List<ObraDTO> obrasYearLowerThanParam(Integer year);

    List<ObraDTO> obrasSameEditorialThanParam(String editorial);
}
