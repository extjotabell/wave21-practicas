package com.example.ejerciciopersonajesstarwarsenvivoypg.repository;

import com.example.ejerciciopersonajesstarwarsenvivoypg.entity.Artist;
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
public class StarWarsRepository {

    public List<Artist> getArtistsListByName(String name){
        return getArtists().stream()
                .filter(artist -> {
                    return artist.getName().toLowerCase().startsWith(name.toLowerCase());
                }).toList();
    }

    private List<Artist> getArtists() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try{
            File jsonFile = ResourceUtils.getFile("classpath:star_wars/artists.json");
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
