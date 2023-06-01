package com.example.demo.controller;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    PersonajeService service;

    public  StarWarsController(PersonajeService service) {
        this.service = service;
    }

    @GetMapping("/buscarPersonaje/{palabra}")
    public ResponseEntity<List<PersonajeDTO>> buscarPersonaje(@PathVariable String palabra){
        return new ResponseEntity<>(service.buscarPersonaje(palabra), HttpStatus.OK);
    }

}
