package com.EjercicioAsincronico.StarWars.Repositories;

import com.EjercicioAsincronico.StarWars.Models.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements IStarWarsRepository {
    private static final String JSON_PATH = "classpath:starwars.json";
    private final List<Character> data;

    public StarWarsRepositoryImpl() {
        data = loadJsonData();
    }

    public List<Character> findAllByNameContainsWord(String word){
        return data.stream()
                .filter(character -> character.nameContainsWord(word))
                .collect(Collectors.toList());

    }

    private List<Character> loadJsonData() {
        File file = new File(JSON_PATH);
        try{
            file = ResourceUtils.getFile(JSON_PATH);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Character>> typeReference = new TypeReference<List<Character>>() {};
        List<Character> characters = null;

        try {
            characters = mapper.readValue(file, typeReference);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return characters;
    }
}
