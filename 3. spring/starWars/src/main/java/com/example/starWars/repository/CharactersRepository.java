package com.example.starWars.repository;

import com.example.starWars.entitys.Character;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class CharactersRepository {

    List<Character> characterList = new ArrayList<>();

    public CharactersRepository(){
        this.characterList = getCharacterJSON();
    }



    private List<Character> getCharacterJSON() {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy( PropertyNamingStrategy.SNAKE_CASE );
        try{
            File jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            return objectMapper.readValue(jsonFile, new TypeReference<>() {
            });

        }catch ( FileNotFoundException e ){
            System.out.println("se rompio todo");
            System.out.println(e.getMessage());
        }catch( JsonProcessingException err ){
            System.out.println("se rompio todo el JSON, estas despedido");
            System.out.println(err.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }
}
