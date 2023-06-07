package com.ejercicio.calculaCaloria.repository;

import com.ejercicio.calculaCaloria.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientRepository {
    private final List<Ingredient> database;

    public IngredientRepository() {
        this.database = loadDataBase();
    }

    public List<Ingredient> findAllByNameContains(String query) {
        return database.stream()
                .filter(ingredient -> matchWith(query, ingredient))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, Ingredient ingredient) {
        return ingredient.getName().toUpperCase().contains(query.toUpperCase());
    }

    public List<Ingredient> getDatabase() {
        return database;
    }

    public List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredientList = null;
        try {
            ingredientList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientList;
    }
}
