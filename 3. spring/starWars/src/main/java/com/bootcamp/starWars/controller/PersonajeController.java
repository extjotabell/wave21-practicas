package com.bootcamp.starWars.controller;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.service.IPersonajeService;
import com.bootcamp.starWars.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/find")
public class PersonajeController {
    IPersonajeService service;

    public PersonajeController(IPersonajeService personajeservice){
        this.service = personajeservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonajeDTO>> findAll(){

      /*  if ( servicio.findAll().size() == 0){
            return new ResponseEntity<List<PersonajeDTO>>("NO EXISTEN PERSONAJES EN LA BBDD",HttpStatus.OK);
        }*/
        return new ResponseEntity<List<PersonajeDTO>>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){

        return  ResponseEntity.status(HttpStatus.OK).body(this.service.findByName(name));


    }

}
