package com.calories.calories.repository;

import com.calories.calories.model.Ingredient;
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
public class IngredientRepository {

    List<Ingredient> ingredients;

    public IngredientRepository() {
        this.ingredients = getIngredients();
    }

    public Ingredient findIngredient(String name){
        Ingredient ingredient = ingredients.stream()
                .filter(i -> i.getName()
                        .equalsIgnoreCase(name)).findFirst()
                .orElse(null);
        return ingredient;
    }

    private List<Ingredient> getIngredients() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try {
            File jsonFile = ResourceUtils.getFile("classpath:food.json");
            return objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            System.out.println("Mal formateo de JSON");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("No se pudo leer archivo el json");
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

}
