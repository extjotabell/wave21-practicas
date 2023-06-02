package com.example.generico.repository;

import com.example.generico.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepository {
  private static final List<Food> foods = new ArrayList<>();

  public Optional<Food> findByName(final String name) {
    return foods
      .stream()
      .filter(f -> f.getName().equalsIgnoreCase(name))
      .findFirst();
  }
  public Integer save(final Food f) {
    f.setId(foods.size());
    foods.add(f);

    return f.getId();
  }
}
