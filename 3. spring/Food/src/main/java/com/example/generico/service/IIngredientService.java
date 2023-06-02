package com.example.generico.service;

import com.example.generico.DTO.FoodDto;
import com.example.generico.DTO.FoodIdDto;
import com.example.generico.DTO.FoodResponseDto;
import com.example.generico.exceptions.IngredientNotFoundException;

public interface IIngredientService {
  public FoodIdDto createFood(final FoodDto fDto) throws IngredientNotFoundException;
  public FoodResponseDto findFoodByName(final String name);
}
