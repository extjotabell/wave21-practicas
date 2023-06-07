package com.ejercicio.calculaCaloria.dto;


import lombok.Data;

@Data
public class IngredientDto {
    private String name;
    private int calories;

    public IngredientDto(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
}
