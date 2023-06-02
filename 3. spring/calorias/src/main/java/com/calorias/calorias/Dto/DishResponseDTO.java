package com.calorias.calorias.Dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DishResponseDTO {
    private String name;
    private Integer totalCalories;
    private List<FoodResponseDTO> ingredients;
    private FoodResponseDTO ingredientWithMaxCalories;
}
