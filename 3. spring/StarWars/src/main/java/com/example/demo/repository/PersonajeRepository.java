package com.example.demo.repository;

import com.example.demo.model.PersonajeModel;
import com.example.demo.service.PersonajeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {
    private List<PersonajeModel> personajeModelList;

    public PersonajeRepository() {
        this.personajeModelList = getPersonajesJSON();
    }

    private List<PersonajeModel> getPersonajesJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try{
            File jsonFile = ResourceUtils.getFile("/Users/mbistolfi/Documents/GitHub/wave21-practicas/3. spring/StarWars/src/main/resources/starwars.json");
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

    public List<PersonajeModel> buscarTodosPorPalabra(String palabra){
        List<PersonajeModel> personajesList = personajeModelList.stream().filter(p -> p.getName().contains(palabra)).toList();
        return personajesList;
    }
}
