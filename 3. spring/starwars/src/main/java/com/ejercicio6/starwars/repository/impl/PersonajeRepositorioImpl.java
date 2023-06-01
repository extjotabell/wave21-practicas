package com.ejercicio6.starwars.repository.impl;

import com.ejercicio6.starwars.entity.Personaje;
import com.ejercicio6.starwars.repository.PersonajeRepositorio;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepositorioImpl implements PersonajeRepositorio {

    private final List<Personaje> database;

    public PersonajeRepositorioImpl() {
        this.database = loadDataBase();
    }

    @Override
    public List<Personaje> findAll() {
        return database;
    }

    private List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
