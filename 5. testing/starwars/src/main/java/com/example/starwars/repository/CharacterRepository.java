package com.example.starwars.repository;

import com.example.starwars.model.Character;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository{
  private List<Character> characters;

  public CharacterRepository () {
    this.characters  = loadDataBase();
  }

  @Override
  public List<Character> findAllByNameContains(String query) {
    return characters.stream()
        .filter(character -> character.nameContains(query))
        .collect(Collectors.toList());
  }

  private List<Character> loadDataBase() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    try{
      File jsonFile = ResourceUtils.getFile("classpath:starwars_characters.json");
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
}
