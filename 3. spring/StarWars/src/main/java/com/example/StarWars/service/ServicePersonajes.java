package com.example.StarWars.service;

import com.example.StarWars.dto.Personaje_Dto;
import com.example.StarWars.entity.Personaje;
import com.example.StarWars.repository.RepositoryPersonaje;
import com.example.StarWars.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePersonajes {
    RepositoryPersonaje repositorio;

    public ServicePersonajes(RepositoryPersonaje repositorio) {
        this.repositorio = repositorio;
    }

    public List<Personaje_Dto> listadoSimilares (String nombre) {
        List<Personaje_Dto> retorno = new ArrayList<>();
        List<Personaje> personajes = this.repositorio.personajes;

        List<Personaje> resultado = personajes.stream().filter(x->x.getName().contains(nombre)).toList();

        for(Personaje per : resultado){
            retorno.add(Mapper.personajeADTO(per));
        }
        return retorno;
    }
}
