package com.example.StarWars.util;

import com.example.StarWars.dto.Personaje_Dto;
import com.example.StarWars.entity.Personaje;

public class Mapper {

    public static Personaje_Dto personajeADTO(Personaje personaje){

        Personaje_Dto personajeDTO = new Personaje_Dto();
        personajeDTO.setGender(personaje.getGender());
        personajeDTO.setHeight(personaje.getHeight());
        personajeDTO.setMass(personaje.getMass());
        personajeDTO.setHomeworld(personaje.getHomeworld());
        personajeDTO.setName(personaje.getName());
        personajeDTO.setSpecies(personaje.getSpecies());
        return personajeDTO;
    }
}