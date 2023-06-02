package com.example.generico.DTO;

import com.example.generico.entity.Ingredient;

public record IngredientResponseDto(Integer id, String name, Integer calories) {
  public IngredientResponseDto(Ingredient i) {
    this(i.getId(), i.getName(), i.getCalories());
  }
}
