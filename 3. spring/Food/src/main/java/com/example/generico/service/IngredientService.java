package com.example.generico.service;

import com.example.generico.DTO.IngredientResponseDto;
import com.example.generico.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IngredientService {
  @Autowired
  IngredientsRepository ingredientsRepository;

  public IngredientResponseDto getiIngredient(final Integer id) {
    return ingredientsRepository
      .getById(id)
      .map(IngredientResponseDto::new)
      .orElseThrow();
  }

  public List<IngredientResponseDto> getAll() {
    return ingredientsRepository.getAll()
      .stream()
      .map(IngredientResponseDto::new)
      .toList();
  }
}
