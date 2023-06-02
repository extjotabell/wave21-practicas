package com.EjercicioAsincronico.StarWars.Services;

import com.EjercicioAsincronico.StarWars.DTOs.CharacterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStarWarsService {
    List<CharacterDTO> findAllByNameContainsWord(String word);
}
