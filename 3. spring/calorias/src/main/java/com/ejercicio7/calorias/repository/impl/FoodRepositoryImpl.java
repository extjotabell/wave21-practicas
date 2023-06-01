package com.ejercicio7.calorias.repository.impl;

import com.ejercicio7.calorias.entity.Ingredients;
import com.ejercicio7.calorias.repository.FoodRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepositoryImpl implements FoodRepository {

    private final List<Ingredients> ingredients;

    public FoodRepositoryImpl(){
        this.ingredients =loadDataBase();
    }

    private List<Ingredients> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredients>> typeRef = new TypeReference<>() {};
        List<Ingredients> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public List<Ingredients> findAllIngredients() {
        return ingredients;
    }
}
