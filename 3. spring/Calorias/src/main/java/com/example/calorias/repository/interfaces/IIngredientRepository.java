package com.example.calorias.repository.interfaces;

import com.example.calorias.model.Ingredient;

public interface IIngredientRepository {
    Ingredient getIngredientByName(String name);
    Ingredient getIngredientWithHighestCalories();
}
