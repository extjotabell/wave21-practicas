package com.practicaSpring.ejercicioStarWars.service;

import com.practicaSpring.ejercicioStarWars.dto.PersonajeDTO;
import com.practicaSpring.ejercicioStarWars.model.Personaje;
import com.practicaSpring.ejercicioStarWars.repository.StarWarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService {
    private StarWarsRepository repositorioSW;

    public StarWarsService(StarWarsRepository repositorioSW){
        this.repositorioSW = repositorioSW;
    }

    public List<PersonajeDTO> listaPersonjesSW(String consulta){
        // Entidades
        List<Personaje> personajesSW = repositorioSW.busXCaracterDeNombre(consulta);

        // Conversion a lista de dto
        List<PersonajeDTO> personajeSWDTO = personajesSW
                .stream()
                .map(personaje ->
                        new PersonajeDTO(
                                personaje.getName(),
                                personaje.getHeight(),
                                personaje.getMass(),
                                personaje.getGender(),
                                personaje.getHomeworld(),
                                personaje.getSpecies()
                        ))
                .collect(Collectors.toList());

        return personajeSWDTO;
    }

    public List<PersonajeDTO> listaPersonjesSW(){

        List<Personaje> todosLosPersonajesSW = repositorioSW.busTodosLosPersonajes();

        // Conversion a lista de dto
        List<PersonajeDTO> personajeSWDTO = todosLosPersonajesSW
                .stream()
                .map(personaje ->
                        new PersonajeDTO(
                                personaje.getName(),
                                personaje.getHeight(),
                                personaje.getMass(),
                                personaje.getGender(),
                                personaje.getHomeworld(),
                                personaje.getSpecies()
                        ))
                .collect(Collectors.toList());

        return personajeSWDTO;

    }



}
