package com.bootcamp.starWars.util;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.entity.Personaje;

public class Mapper {

    public static PersonajeDTO personajeADTO(Personaje personaje){

        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setGender(personaje.getGender());
        personajeDTO.setHeight(personaje.getHeight());
        personajeDTO.setMass(personaje.getMass());
        personajeDTO.setHomeWord(personaje.getHomeworld());
        personajeDTO.setName(personaje.getName());
        personajeDTO.setSpecies(personaje.getSpecies());
        return personajeDTO;
    }
}
