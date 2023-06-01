package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarwarsController {
    @Autowired
    CharacterService characterService;

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> findCharacter(@PathVariable String name){
        return ResponseEntity.ok(characterService.findByName(name));
    }

}
