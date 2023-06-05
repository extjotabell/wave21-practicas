package com.calorias.calorias.repository;

import com.calorias.calorias.model.Food;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepository {

    private List<Food> food;

    public FoodRepository() {
        this.food = getFoodJson();
    }

    private List<Food> getFoodJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Food>> typeRef = new TypeReference<>() {};
        List<Food> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public List<Food> getAllFoods() {
        return food;
    }


    public Food obtenerFood(String nombre) {
        return this.food.stream()
                .filter(food -> food.getName().equals(nombre))
                .findFirst()
                .orElse(null);
    }

}
