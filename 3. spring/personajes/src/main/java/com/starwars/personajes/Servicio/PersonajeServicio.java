package com.starwars.personajes.Servicio;

import com.starwars.personajes.Dto.PersonajeDTO;
import com.starwars.personajes.Entidad.Personaje;
import com.starwars.personajes.Repositorio.PersonajeRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServicio {
    private PersonajeRepositorio _repositorio;
    private ModelMapper modelMapper;

    public PersonajeServicio(PersonajeRepositorio personajeRepositorio){

        this._repositorio = personajeRepositorio;
        this.modelMapper = new ModelMapper();
    }

    public List<PersonajeDTO> buscar(String nombre){
        return this._repositorio.personajes().stream().filter(personaje -> personaje.getName().toLowerCase().contains(nombre.toLowerCase()))
                .map(personaje -> modelMapper.map(personaje, PersonajeDTO.class))
                .collect(Collectors.toList());
    }

    public List<PersonajeDTO> todos(){
        return this._repositorio.personajes().stream().map(personaje -> modelMapper.map(personaje, PersonajeDTO.class))
                .collect(Collectors.toList());
    }
}
