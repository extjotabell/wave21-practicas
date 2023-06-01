package com.bootcamp.starWars.service;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.entity.Personaje;

import java.util.List;

public interface IPersonajeService {

    public List<PersonajeDTO> findAll();
    public List<PersonajeDTO> findByName(String name);
    public List<PersonajeDTO> findBySpecie(String specie);
}
