package com.starwars.starwars.controllers;

import com.starwars.starwars.DTOs.response.CharacterDTO;
import com.starwars.starwars.services.CharacterService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharactersController {

    CharacterService service;


    public CharactersController(CharacterService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> getPartiallyMatchingCharacters(@PathVariable String name) {
    return ResponseEntity.ok(service.listAllPartiallyMatchingCharacters(name));
    }

}
