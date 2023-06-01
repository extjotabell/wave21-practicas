package com.bootcamp.calculadoradecalorias.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuMultiResponseDTO {
    private String dish;
    private IngredientDTO mostCaloricIngredient;
    private List<IngredientDTO> ingredients;
    private double totalCalories;
}
