package com.ejercicio6.starwars.service.impl;

import com.ejercicio6.starwars.dto.PersonajeDTO;
import com.ejercicio6.starwars.entity.Personaje;
import com.ejercicio6.starwars.repository.PersonajeRepositorio;
import com.ejercicio6.starwars.service.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServicioImpl implements PersonajeServicio {

    @Autowired
    private PersonajeRepositorio personajeRepositorio;

    @Override
    public List<PersonajeDTO> getPersonaje(String busqueda) {
        return personajeRepositorio.findAll().stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(busqueda.toLowerCase()))
                .map(personaje -> new PersonajeDTO(personaje.getName()
                        , personaje.getHeight()
                        , personaje.getMass()
                        , personaje.getGender()
                        , personaje.getSpecies()))
                .collect(Collectors.toList());
    }
}
