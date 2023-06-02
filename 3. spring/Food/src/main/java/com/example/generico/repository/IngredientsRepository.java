package com.example.generico.repository;

import com.example.generico.entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class IngredientsRepository {
  private final static String PATH_DB = "classpath:food.json";
  private static final List<Ingredient> ingredients =  Formatter.jsonToArrayObject(PATH_DB);

  public List<Ingredient> getAll() {
    return ingredients;
  }

  public Optional<Ingredient> getById(final Integer id) {
    return Optional.of(ingredients.get(id));
  }

  public Optional<Ingredient> findByName(final String name) {
    return ingredients
      .stream()
      .filter(i -> i.getName().equalsIgnoreCase(name))
      .findFirst();
  }
}
