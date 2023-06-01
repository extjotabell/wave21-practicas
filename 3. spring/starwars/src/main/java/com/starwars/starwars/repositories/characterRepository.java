package com.starwars.starwars.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.starwars.starwars.model.SWCharacter;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class characterRepository {

    private List<SWCharacter> characters;

    public characterRepository(){

        characters = new ArrayList<>();
        initData();
    }

    private List<SWCharacter> getCharacterList() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try{
            File jsonFile = ResourceUtils.getFile("classpath:static/starwars_char.json");
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
    public void initData() {
        characters = getCharacterList();
       // cleanCharactersList(); -> me faltaría arreglarlo para que quede bien si vienen "NA"
    }

    private void cleanCharactersList() {

        for (int i = 0; i < characters.size()-1; i++) {
            SWCharacter character = characters.get(i);
            if(notANumber(character.getMass())) character.setMass(null);
            if(notANumber(character.getHeight())) character.setHeight(null);
        }

    }

    private boolean notANumber(String mass) {
        return mass.matches("-?\\d+(\\.\\d+)?");
    }


    public List<SWCharacter> findPartiallyByName(String name){

        return characters.stream().filter(c -> c.getName().contains(name)).toList();
    }



}
