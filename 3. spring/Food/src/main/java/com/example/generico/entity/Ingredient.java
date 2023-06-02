package com.example.generico.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

@Getter
@Setter
public class Ingredient {
  Integer id;
  String name;
  int calories;

  public Ingredient(String name, Integer calories) {
    this.name = name;
    this.calories = calories;
  }

  public Ingredient(Integer id, String name, Integer calories) {
    this.id = id;
    this.name = name;
    this.calories = calories;
  }
}
