package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.SiniestroDTO;

import java.util.List;

public interface ISiniestroService {

    SiniestroDTO saveSiniestro(Long id, SiniestroDTO siniestroDTO);
    List<SiniestroDTO> findAll();
    SiniestroDTO findByID(Long id);
    SiniestroDTO deleteSiniestro(Long idVehiculo, Long idSiniestro);

}
