package com.StarWars.starWars.controller;

import com.StarWars.starWars.dto.PersonajeDTO;
import com.StarWars.starWars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    @Autowired
    PersonajeService personajeService;


    @GetMapping("/{name}")
    public List<PersonajeDTO> findCharacter(@PathVariable String name){
        return personajeService.findCharacter(name);
    }

}
