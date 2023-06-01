package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.StarWarsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("starWars")
public class StarWarsController {
    private StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService){
        this.starWarsService = starWarsService;
    }

    @GetMapping("find/{name}")
    public ResponseEntity<List<CharacterDTO>> findCharacterByName(@PathVariable String name){
        return ResponseEntity.ok(starWarsService.findCharacterByName(name));
    }
}
