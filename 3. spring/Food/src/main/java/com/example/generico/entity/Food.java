package com.example.generico.entity;

import com.example.generico.DTO.FoodDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Food {
  Integer id;
  String name;
  List<Ingredient> ingredients;
  float timeOfCooking;
}
