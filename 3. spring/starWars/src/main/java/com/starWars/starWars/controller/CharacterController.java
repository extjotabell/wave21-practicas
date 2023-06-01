package com.starWars.starWars.controller;

import com.starWars.starWars.dto.response.CharacterInfoDTO;
import com.starWars.starWars.model.Character;
import com.starWars.starWars.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping("/characters")
    public ResponseEntity<List<Character>> characters(){
        return new ResponseEntity<>(service.listCharacter(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public List<CharacterInfoDTO> findCharacter(@PathVariable String name){
        return service.findCharacter(name);
    }

}
