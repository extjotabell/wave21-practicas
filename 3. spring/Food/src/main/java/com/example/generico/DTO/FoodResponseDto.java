package com.example.generico.DTO;

import java.util.List;

public record FoodResponseDto (Integer caloriasTotales, List<IngredientResponseDto> ingredientes, Integer totalCalorias){
}
