package com.example.calories.repository;

import com.example.calories.model.Ingredient;

import java.util.List;

public interface CalculatorRepository {
    public boolean saveIngredients(List<Ingredient> model);
}
