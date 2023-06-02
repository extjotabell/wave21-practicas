package com.practicaSpring.ejercicioStarWars.controller;

import com.practicaSpring.ejercicioStarWars.dto.PersonajeDTO;
import com.practicaSpring.ejercicioStarWars.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private StarWarsService servicioSW;

    @GetMapping("personajesSW/{consulta}")
    public List<PersonajeDTO> busrcarPersonaje(@PathVariable String consulta){
        return servicioSW.listaPersonjesSW(consulta);

    }

    @GetMapping("/personajesSW")
    public ResponseEntity<List<PersonajeDTO>> findCharacters(){
        return new ResponseEntity<>(servicioSW.listaPersonjesSW(), HttpStatus.OK);
    }


}
