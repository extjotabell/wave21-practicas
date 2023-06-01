package com.example.starWars.controller;

import com.example.starWars.dto.CharacterDTO;
import com.example.starWars.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    CharacterService characterService;

    @GetMapping("/charactersByName/{name}")
    public ResponseEntity<List<CharacterDTO>> findCharactersByName(@PathVariable String name){
        List<CharacterDTO> filteredList = characterService.charactersDTOfiltered(name);
        if(!filteredList.isEmpty() ){
            return new ResponseEntity<>(filteredList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/characters")
    public ResponseEntity<List<CharacterDTO>> findCharacters(){

        return new ResponseEntity<>(characterService.tranformEntityToDTO(), HttpStatus.OK);
    }

}


/*
* @GetMapping("/charactersByName")
    public ResponseEntity<List<CharacterDTO>> findCharactersByName(@RequestParam String name){
        List<CharacterDTO> filteredList = characterService.charactersDTOfiltered(name);
        if(filteredList != null){
            return new ResponseEntity<>(filteredList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }
* */