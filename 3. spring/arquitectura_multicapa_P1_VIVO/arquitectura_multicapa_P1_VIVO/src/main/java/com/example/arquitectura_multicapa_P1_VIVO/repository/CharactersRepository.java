package com.example.arquitectura_multicapa_P1_VIVO.repository;

import com.example.arquitectura_multicapa_P1_VIVO.entity.Characters;
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
public class CharactersRepository {

    public List<Characters> findCharacterByName(String name) {
        List<Characters> charactersList = getCharactersJson().stream()
                .filter(n -> n.getName().contains(name))
                .collect(Collectors.toList());

       return charactersList;
    }


    private List<Characters> getCharactersJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try {
            File jsonFile = ResourceUtils.getFile("classpath:json_data/starwars.json");
            return objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            System.out.println("Mal formateo de JSON");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("No se pudo leer archivo el json");
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
