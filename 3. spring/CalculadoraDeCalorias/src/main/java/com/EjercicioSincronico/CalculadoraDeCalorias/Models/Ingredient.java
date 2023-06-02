package com.EjercicioSincronico.CalculadoraDeCalorias.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Ingredient {
    private String name;
    private Integer calories;

    public Integer calculateCalories(Double weight){
        return (int) ((calories / 100) * weight);
    }
}
