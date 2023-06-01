package com.example.starwars.repository;

import com.example.starwars.model.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository {
    public static List<Character> characters = new ArrayList<>();

    public List<Character> findCharacterByName(String name){
        return characters.stream()
                .filter(character -> character.getName().contains(name))
                .collect(Collectors.toList());
    }
}
