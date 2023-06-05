package com.bootcamp.starWars.service;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.entity.Personaje;
import com.bootcamp.starWars.exception.NoCharacterFoundException;
import com.bootcamp.starWars.repository.PersonajeRepository;
import com.bootcamp.starWars.util.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            resultado.add(new PersonajeDTO(per.getName(),per.getHeight(),per.getMass(),per.getGender(),per.getHomeworld(),per.getSpecies()));
        }
        return resultado ;
    }

    @Override
    public List<PersonajeDTO> findByName(String name) {

    List<Personaje> personajes = repo.findbyName(name);
    List<PersonajeDTO> personajeDTO = new ArrayList<>();

    if(personajes == null || personajes.size() == 0 ){
        throw new NoCharacterFoundException("El Nombre no se encuentra en la BBDD");
    }

    for(Personaje per : personajes){
        personajeDTO.add(Mapper.personajeADTO(per));
    }
    return personajeDTO;
    }

    @Override
    public List<PersonajeDTO> findBySpecie(String specie) {
        return null;
    }
}
