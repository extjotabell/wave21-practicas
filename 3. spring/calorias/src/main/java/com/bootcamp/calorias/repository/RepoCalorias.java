package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class RepoCalorias implements  Repository{
List<Ingrediente> ingredientes;


    public RepoCalorias(){
        ingredientes = new ArrayList<>();
        ingredientes = loadDataBase();

    }

    @Override
    public List<Ingrediente> findAll() {
        return this.ingredientes;
    }

    @Override
    public Ingrediente findbyName(String name) {

        return null;
    }

    @Override
    public void add(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }




    private List<Ingrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }
}
