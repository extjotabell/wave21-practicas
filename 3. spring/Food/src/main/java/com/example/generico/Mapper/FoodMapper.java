package com.example.generico.Mapper;

import com.example.generico.DTO.FoodResponseDto;
import com.example.generico.DTO.IngredientResponseDto;
import com.example.generico.entity.Food;
import com.example.generico.entity.Ingredient;

import java.util.Comparator;

public class FoodMapper {
  public static FoodResponseDto foodToFoodResponseDto(final Food f) {
    Comparator<Ingredient> c = Comparator.comparing(Ingredient::getCalories);
    var ingredients = f.getIngredients()
      .stream()
      .sorted(c)
      .toList();

    Integer total = ingredients
      .stream()
      .mapToInt(Ingredient::getCalories)
      .sum();

    var ingredientsDto = ingredients
      .stream()
      .map(FoodMapper::ingredientToIngredientResponseDto)
      .toList();

    return new FoodResponseDto(total, ingredientsDto, total);
  }

  public static IngredientResponseDto ingredientToIngredientResponseDto(final Ingredient i) {
    return new IngredientResponseDto(i.getId(), i.getName(), i.getCalories());
  }
}
