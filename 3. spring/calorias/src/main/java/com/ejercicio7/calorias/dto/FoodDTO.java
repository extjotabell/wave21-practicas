package com.ejercicio7.calorias.dto;

import com.ejercicio7.calorias.entity.Ingredients;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class FoodDTO {
    private Integer totalCalories;
    private Ingredients ingredient;
    private List<Ingredients> ingredients;
}
