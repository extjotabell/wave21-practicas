package com.example.demo.service;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.model.PersonajeModel;
import com.example.demo.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService {

    PersonajeRepository repository;

    public PersonajeService(PersonajeRepository repository){
        this.repository = repository;
    }

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
    public List<PersonajeDTO> buscarPersonaje(String palabra){
        List<PersonajeModel> personajesModelList = repository.buscarTodosPorPalabra(palabra);
        List<PersonajeDTO> personajeDTOList = personajesModelList
                .stream()
                .map( personajeModel -> {
                    PersonajeDTO personajeDTO = new PersonajeDTO();
                    personajeDTO.setName(personajeModel.getName());
                    personajeDTO.setHeight(personajeModel.getHeight());
                    personajeDTO.setMass(personajeModel.getMass());
                    personajeDTO.setGender(personajeModel.getGender());
                    personajeDTO.setHomeworld(personajeModel.getHomeworld());
                    personajeDTO.setSpecies(personajeModel.getSpecies());
                    return personajeDTO;
                })
                .toList();
         return personajeDTOList;
    }
}
