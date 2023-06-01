package com.example.calories.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private List<IngredientDto> listIngredients;
}
