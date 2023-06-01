package com.example.starwars;

import com.example.starwars.model.Character;
import com.example.starwars.repository.StarWarsRepository;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;

@SpringBootApplication
public class StarWarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarWarsApplication.class, args);

        try (InputStream in = new FileInputStream("/Users/mtato/Development/bootcamp/git/wave21-practicas/3. spring/StarWars/src/main/resources/json/3. starwars.json");)
        {
            Character[] characters = new ObjectMapper().readValue(new JsonFactory().createJsonParser(in), Character[].class);
            StarWarsRepository.characters.addAll(Arrays.asList(characters));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
