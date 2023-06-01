package com.starwars.personajes.Servicio;

import com.starwars.personajes.Entidad.Personaje;
import com.starwars.personajes.Repositorio.PersonajeRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServicio {
    private PersonajeRepositorio _repositorio;

    public PersonajeServicio(PersonajeRepositorio personajeRepositorio){
        this._repositorio = personajeRepositorio;
    }

    public List<Personaje> buscar(String nombre){
        return this._repositorio.personajes().stream().filter(personaje -> personaje.getName().contains(nombre))
                .collect(Collectors.toList());
    }

    public List<Personaje> todos(){
        return this._repositorio.personajes();
    }
}
