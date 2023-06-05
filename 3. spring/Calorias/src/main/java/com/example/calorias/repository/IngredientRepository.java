package com.example.calorias.repository;

import com.example.calorias.model.Ingredient;
import com.example.calorias.repository.interfaces.IIngredientRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class IngredientRepository implements IIngredientRepository {
    private List<Ingredient> ingredients = new ArrayList<>();
    @Override
    public Ingredient getIngredientByName(String name) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Ingredient getIngredientWithHighestCalories() {
        return ingredients.stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .orElse(null);
    }
}
