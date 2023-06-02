package com.bootcamp.starWars.repository;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class PersonajeRepository implements Repository{
    List<Personaje> personajes;

    public PersonajeRepository(){
        personajes = new ArrayList<>();
        //cargarPersonajes();
        personajes = loadDataBase();
    }

    public void cargarPersonajes(){
        Personaje personaje = new Personaje("Darth", 172,12,"Black","Brown","blue","55","Yes","No","MAx");
        Personaje personaje1 = new Personaje("Darth", 171,12,"Black","Blue","blue","55","Yes","No","MAx");
        Personaje personaje2 = new Personaje("Max", 172,12,"Black","Brown","blue","55","Yes","No","MAx");

        personajes.add(personaje);
        personajes.add(personaje1);
        personajes.add(personaje2);
    }

    private List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
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

    @Override
    public List<Personaje> findAll() {
        return this.personajes;
    }

    @Override
    public List<Personaje> findbyName(String name) {
        return this.personajes.stream().filter(n->n.getName().equals(name)).toList();
    }

    @Override
    public void add(Object obj) {
        this.personajes.add((Personaje) obj);
    }

    @Override
    public void delete(Object obj) {
        this.personajes.remove((Personaje) obj);
    }
}
