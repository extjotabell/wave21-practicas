package com.example.arquitectura_multicapa_P1_VIVO.controller;

import com.example.arquitectura_multicapa_P1_VIVO.dto.response.CharacterResponseDTO;
import com.example.arquitectura_multicapa_P1_VIVO.entity.Characters;
import com.example.arquitectura_multicapa_P1_VIVO.services.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CharactersController {

    CharacterService service;

    public CharactersController(CharacterService service) {
        this.service = service;
    }

    @GetMapping("/findCharacter")
    public List<CharacterResponseDTO> getAllCharacters(@RequestParam String name) {
        return service.listCharacters(name);
    }
}
