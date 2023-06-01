package com.example.calories.repository;

import com.example.calories.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CalculatorRepositoryImpl implements CalculatorRepository{
    private List<Ingredient> listIngredient;
    @Override
    public boolean saveIngredients(List<Ingredient> model) {
        listIngredient = model;
        return true;
    }
}
