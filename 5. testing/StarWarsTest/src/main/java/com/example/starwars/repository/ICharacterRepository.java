package com.example.starwars.repository;

import com.example.starwars.model.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> findAllByNameContains(String query);
}
