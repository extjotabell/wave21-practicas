package com.example.StarsWars.repository;

import com.example.StarsWars.entity.Personaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository

public class StarWarsRepository {
            private ArrayList<Personaje> personajesList;
            private List<Character> characters;

            /*public StarWarsRepository(){
                this.characters = cargarJson();
            }*/

            public StarWarsRepository(){
                this.personajesList = new ArrayList<>();
                initData();
            }

            public void initData(){
                Personaje luke = new Personaje("Luke Skywalker", 80, 50, "blonde", "white", "green",
                        "15/02/2021", "m", "marte", "rat");
                Personaje darth = new Personaje("Darth Vader", 50, 50, "black", "blak", "yellow",
                        "15/02/2010", "m", "jupiter", "rat");
                Personaje darth2 = new Personaje("Darth Maul", 120, 50, "blonde", "white", "green",
                        "15/02/2000", "m", "saturno", "rat");

                personajesList.addAll(Arrays.asList(luke,darth,darth2));
            }

            public ArrayList<Personaje> returnPersonajesList(){
                return personajesList;
            }

            public ArrayList<Personaje> filterByName(String name) {
                ArrayList<Personaje> personajesByName = new ArrayList<>();
                for (Personaje personaje: personajesList ) {
                    if(personaje.getName().toLowerCase().contains(name.toLowerCase())){
                        personajesByName.add(personaje);
                    }
                }
                return personajesByName;
            }

            private List<Character> cargarJson() {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
                try {
                    File jsonFile = ResourceUtils.getFile("classpath:starwars_characters.json");
                    return objectMapper.readValue(jsonFile, new TypeReference<List<>>() {
                    });
                } catch (JsonProcessingException e) {
                    System.out.println("Mal formato de JSON");
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("No se pudo leer archivo JSON");
                    System.out.println(e.getMessage());

                }
                return new ArrayList<>();
            }
}
