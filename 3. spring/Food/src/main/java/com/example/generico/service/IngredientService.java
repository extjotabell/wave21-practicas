package com.example.generico.service;

import com.example.generico.DTO.IngredientResponseDto;
import com.example.generico.Mapper.FoodMapper;
import com.example.generico.repository.IngredientsRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
  @Autowired
  IngredientsRepository ingredientsRepository;

  public IngredientResponseDto getiIngredient(final Integer id) {
    return ingredientsRepository
      .getById(id)
      .map(FoodMapper::ingredientToIngredientResponseDto)
      .orElseThrow();
  }

  public List<IngredientResponseDto> getAll() {
    return ingredientsRepository.getAll()
      .stream()
      .map(FoodMapper::ingredientToIngredientResponseDto)
      .toList();
  }
}
