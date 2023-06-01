package com.example.generico.controller;

import com.example.generico.DTO.CharacterDTO;
import com.example.generico.DTO.CharacterIdDTO;
import com.example.generico.DTO.CharacterResponseDTO;
import com.example.generico.entity.Character;
import com.example.generico.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {
  @Autowired
  CharacterService characterService;

  @GetMapping("/personajes")
  public ResponseEntity<List<CharacterResponseDTO>> getCharacters() {
    List<CharacterResponseDTO> characters = characterService.getAllCharacters();

    return new ResponseEntity<>(characters, HttpStatus.OK);
  }

  @GetMapping("/personaje/{name}")
  public ResponseEntity<List<CharacterResponseDTO>> getCharacter(@PathVariable final String name) {
    List<CharacterResponseDTO> character = characterService.searchCharacterByName(name);

    return new ResponseEntity<>(character, HttpStatus.OK);
  }

  @PostMapping("/personajes")
  public ResponseEntity<List<CharacterIdDTO>> createCharacters(@RequestBody final List<CharacterDTO> characters) {
    List<CharacterIdDTO> characterIds = characterService.createMultiCharacters(characters);

    return new ResponseEntity<>(characterIds, HttpStatus.OK);
  }
  @PostMapping("/personaje")
  public ResponseEntity<CharacterIdDTO> createCharacter(@RequestBody final CharacterDTO character) {
    CharacterIdDTO characterId = characterService.createCharacter(character);

    return new ResponseEntity<>(characterId, HttpStatus.OK);
  }
}
