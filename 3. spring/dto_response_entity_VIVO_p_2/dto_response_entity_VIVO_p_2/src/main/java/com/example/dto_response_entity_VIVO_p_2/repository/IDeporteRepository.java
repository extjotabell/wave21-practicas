package com.example.dto_response_entity_VIVO_p_2.repository;

import com.example.dto_response_entity_VIVO_p_2.dto.Response.ResponseDTO;
import com.example.dto_response_entity_VIVO_p_2.entity.Deporte;

import java.util.List;

public interface IDeporteRepository {
    List<Deporte> getSport();
    String getByName(String name);
    List<ResponseDTO> getSportsByPerson();
}
