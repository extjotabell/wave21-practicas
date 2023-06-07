package com.ejercicio.calculaCaloria.model;


import com.ejercicio.calculaCaloria.dto.IngredientDto;
import com.ejercicio.calculaCaloria.utils.Mapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plate {
    private String name;
    private double calories;
    private List<Ingredient> ingredientList;

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public IngredientDto getMaxCalorieIngredient(){
        // TODO Encontrar el ingrediente con más calorías de la lista
        return ingredientList
                .stream()
                .map(Mapper::DTOfromIngredient)
                .max(Comparator.comparing(IngredientDto::getCalories))
                .orElse(null);
    }
}
