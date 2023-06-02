package com.example.generico.service;

import com.example.generico.DTO.FoodDto;
import com.example.generico.DTO.FoodIdDto;
import com.example.generico.DTO.FoodResponseDto;
import com.example.generico.Mapper.FoodMapper;
import com.example.generico.entity.Food;
import com.example.generico.entity.Ingredient;
import com.example.generico.exceptions.FoodNotFoundException;
import com.example.generico.exceptions.IngredientNotFoundException;
import com.example.generico.repository.FoodRepository;
import com.example.generico.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodService {
  @Autowired
  IngredientsRepository ingredientsRepository;
  @Autowired
  FoodRepository foodRepository;

  private List<Ingredient> getParsedIngredients(List<Integer> ids) {
      return  ids
        .stream()
        .map(ingredientsRepository::getById)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .toList();
  }

  public FoodIdDto createFood(final FoodDto fDto) throws IngredientNotFoundException {
    try {
      Food food = new Food();

      food.setName(fDto.name());
      food.setIngredients(getParsedIngredients(fDto.ingredientsId()));

      return new FoodIdDto(foodRepository.save(food));
    } catch(IndexOutOfBoundsException e) {
      throw new IngredientNotFoundException("No se encontraron todos los ids de los ingredientes");
    }
  }

  public FoodResponseDto findFoodByName(final String name) {
    return foodRepository.findByName(name)
      .map(FoodMapper::foodToFoodResponseDto)
      .orElseThrow(() -> new FoodNotFoundException("No se encontro la comida "+name));
  }
}
