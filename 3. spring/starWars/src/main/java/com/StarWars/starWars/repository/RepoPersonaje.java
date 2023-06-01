package com.StarWars.starWars.repository;

import com.StarWars.starWars.model.Personaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoPersonaje {

private List<Personaje> characters;

    public RepoPersonaje() {
        this.characters = getStarWarsJson();
    }

    private List<Personaje> getStarWarsJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try{
            File jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            return objectMapper.readValue(jsonFile, new TypeReference<>() {});
        }catch (JsonProcessingException e){
            System.out.println("Mal formateo de JSON");
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("No se pudo leer archivo el json");
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    public List<Personaje> findByName (String name){
        List<Personaje> findCharacters = characters.stream().filter(c -> c.getName().contains(name)).toList();
        return findCharacters;
    }
}
