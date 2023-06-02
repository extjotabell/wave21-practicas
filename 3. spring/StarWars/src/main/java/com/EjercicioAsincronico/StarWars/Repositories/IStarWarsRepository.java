package com.EjercicioAsincronico.StarWars.Repositories;

import com.EjercicioAsincronico.StarWars.Models.Character;

import java.util.List;

public interface IStarWarsRepository {
    List<Character> findAllByNameContainsWord(String word);
}
