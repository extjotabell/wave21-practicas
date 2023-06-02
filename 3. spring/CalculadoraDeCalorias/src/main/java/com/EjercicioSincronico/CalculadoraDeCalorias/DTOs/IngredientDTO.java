package com.EjercicioSincronico.CalculadoraDeCalorias.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {
    private String name;
    private Integer calories;
    private Double weight;
}
