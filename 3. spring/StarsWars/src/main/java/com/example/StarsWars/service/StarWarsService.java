package com.example.StarsWars.service;

import com.example.StarsWars.dto.PersonajesDTO;
import com.example.StarsWars.entity.Personaje;
import com.example.StarsWars.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StarWarsService {

    @Autowired
    StarWarsRepository repo;

    ArrayList<PersonajesDTO> personajesDTOS = new ArrayList<>();

    public ArrayList<PersonajesDTO> searchPerName(String name){
        personajesDTOS.clear();
        ArrayList<Personaje> personajesList = repo.filterByName(name);
        for (int i =0; i < personajesList.size(); i++) {
            Personaje personaje = personajesList.get(i);
            PersonajesDTO personajeDto = new PersonajesDTO(personaje.getName(),personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies());
            personajesDTOS.add(personajeDto);
        }
        return personajesDTOS;
    }

    /* en el repo van las listas con los datos, el repo devuelve esa lista y en service se mapea a un objeto dto y ese dto es el que se manda al controller.*/


}
