package com.ejerciciopracticoindividual.joyeria.service;

import com.ejerciciopracticoindividual.joyeria.dto.JoyaDTO;

import java.util.List;

public interface JoyaService {

    String guardar(JoyaDTO joyaDTO);

    JoyaDTO guardar(Integer id,JoyaDTO joyaDTO);

    List<JoyaDTO> listar();


    void borrar(Integer id);
}
