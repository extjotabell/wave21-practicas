package com.example.StarsWars.controller;

import com.example.StarsWars.dto.PersonajesDTO;
import com.example.StarsWars.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {
    //list.addAll(Arrays.asList(elemento1, elemento2,elemento3));
    //@JsonIgnore ignora algun dato en el constructor de Lombok

    @Autowired
    StarWarsService service;

    @GetMapping("personajesByName")
    public ResponseEntity<ArrayList<PersonajesDTO>> personajaesByName(@RequestParam String name){
        return new ResponseEntity<>(service.searchPerName(name), HttpStatus.OK);
    }
}
