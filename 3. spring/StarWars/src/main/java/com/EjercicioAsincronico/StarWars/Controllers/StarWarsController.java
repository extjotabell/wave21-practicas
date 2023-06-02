package com.EjercicioAsincronico.StarWars.Controllers;

import com.EjercicioAsincronico.StarWars.DTOs.CharacterDTO;
import com.EjercicioAsincronico.StarWars.Services.IStarWarsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class StarWarsController {
    private final IStarWarsService _starWarsService;

    public StarWarsController(IStarWarsService _starWarsService) {
        this._starWarsService = _starWarsService;
    }

    @GetMapping("{query}")
    public List<CharacterDTO> findAllByNameContainsWord(@PathVariable String query){
        return _starWarsService.findAllByNameContainsWord(query);
    }
}
