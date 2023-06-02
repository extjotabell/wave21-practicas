package com.practicaSpring.ejercicioStarWars.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import com.practicaSpring.ejercicioStarWars.model.Personaje;
import org.springframework.util.ResourceUtils;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.stream.Collectors;

@Repository
@Getter
public class StarWarsRepository {

    private List<Personaje> personajeListaSW;

    public StarWarsRepository() {
        personajeListaSW = cargarPersonajeJson();
    }

    public List<Personaje> busXCaracterDeNombre(String consulta){
        return personajeListaSW.stream()
                               .filter(personaje -> personaje.nombreContiene(consulta))
                               .collect(Collectors.toList());
    }

    public List<Personaje> busTodosLosPersonajes(){
        return personajeListaSW;
    }

    private List<Personaje> cargarPersonajeJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try{
            File arcivoJson = ResourceUtils.getFile("classpath:jsonData/starwars.json");
            return objectMapper.readValue(arcivoJson, new TypeReference<>() {});
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
