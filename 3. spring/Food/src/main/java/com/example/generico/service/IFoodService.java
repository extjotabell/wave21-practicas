package com.example.generico.service;

import com.example.generico.DTO.FoodDto;
import com.example.generico.DTO.FoodIdDto;
import com.example.generico.DTO.FoodResponseDto;
import com.example.generico.entity.Ingredient;
import com.example.generico.exceptions.IngredientNotFoundException;

import java.util.List;

public interface IFoodService {
  FoodIdDto createFood(final FoodDto fDto) throws IngredientNotFoundException;
  FoodResponseDto findFoodByName(final String name);
}
