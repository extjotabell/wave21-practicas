package com.starwars.personajes.Repositorio;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.starwars.personajes.Entidad.Personaje;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositorio {
    private List<Personaje> personajes;
    public PersonajeRepositorio(){
        this.personajes = new ArrayList<>();
    }
    public List<Personaje> personajes(){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
            File file = new ClassPathResource("starwars.json").getFile();
            this.personajes = objectMapper.readValue(file, new TypeReference<List<Personaje>>() {});
            return this.personajes;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return this.personajes;
    }
}
