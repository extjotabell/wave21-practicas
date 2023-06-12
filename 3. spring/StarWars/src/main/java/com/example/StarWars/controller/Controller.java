package com.example.StarWars.controller;

import com.example.StarWars.dto.Personaje_Dto;
import com.example.StarWars.service.ServicePersonajes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class Controller {
    ServicePersonajes service;

    public Controller(ServicePersonajes service) {
        this.service = service;
    }

    @GetMapping({"/findCharacter/{name}"})
    public ResponseEntity<List<Personaje_Dto>> encontrarSimilares(@PathVariable String name)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(this.service.listadoSimilares(name));
    }
}
