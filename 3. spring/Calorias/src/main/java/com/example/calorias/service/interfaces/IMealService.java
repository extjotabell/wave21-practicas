package com.example.calorias.service.interfaces;

import com.example.calorias.dto.IngredientDTO;
import com.example.calorias.model.Ingredient;

import java.util.List;

public interface IMealService {
    Integer getCalories(String name, Integer weight);
    List<IngredientDTO> getIngredients(String name, Integer weight);
}
