package com.ejercicio1.starWars.controller;

// CharacterController.java
import com.ejercicio1.starWars.dto.CharacterDTO;
import com.ejercicio1.starWars.service.CharacterSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    private CharacterSearchService searchService;

    public CharacterController() {
        searchService = new CharacterSearchService();
    }

    @GetMapping("/characters")
    public List<CharacterDTO> searchCharacters(@RequestParam("keyword") String keyword) {
        return searchService.searchCharacters(keyword);
    }
}


