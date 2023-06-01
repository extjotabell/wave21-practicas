package com.StarWars.starWars.service;

import com.StarWars.starWars.dto.PersonajeDTO;
import com.StarWars.starWars.repository.RepoPersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService {

    @Autowired
    RepoPersonaje repoPersonaje;

    public List<PersonajeDTO> findCharacter(String name){
        List<PersonajeDTO> characters = repoPersonaje
                .findByName(name)
                .stream()
                .map(c -> new PersonajeDTO(c.getName(),c.getHeight(),c.getMass(),c.getGender(),c.getHomeworld(), c.getSpecies()))
                .toList();
        return characters;
    }
}
