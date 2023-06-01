package com.bootcamp.starWars.service;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.entity.Personaje;
import com.bootcamp.starWars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService{
    //Conexion con el Repo
    PersonajeRepository repo ;

    public PersonajeService(PersonajeRepository repo){
        this.repo = repo;
    }

    @Override
    public List<PersonajeDTO> findAll() {
        List<PersonajeDTO> resultado = new ArrayList<>();
        for(Personaje per : repo.findAll()){
            resultado.add(new PersonajeDTO(per.getName(),per.getHeight(),per.getMass(),per.getGender(),per.getHomeWord(),per.getSpecies()));
        }
        return resultado ;
    }

    @Override
    public List<PersonajeDTO> findByName(String name) {

    List<PersonajeDTO> personajes = new ArrayList<>();
    if(repo.findbyName(name) == null){
        return null;
    }
    for(Personaje per : repo.findbyName(name)){
        personajes.add(new PersonajeDTO(per.getName(),per.getHeight(),per.getMass(),per.getGender(),per.getHomeWord(),per.getSpecies()));
    }
    return personajes;
    }

    @Override
    public List<PersonajeDTO> findBySpecie(String specie) {
        return null;
    }
}
