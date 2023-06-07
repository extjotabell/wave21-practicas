package com.ejercicio.calculaCaloria.dto;

import com.ejercicio.calculaCaloria.model.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class PlateDto {
    private String name;
    private double calories;
    private List<IngredientDto> ingredientList;
    private IngredientDto maxCalorieIngredient;
}
