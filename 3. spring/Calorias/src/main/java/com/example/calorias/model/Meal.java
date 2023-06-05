package com.example.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    private String name;
    private Integer wight;
    private Map<Ingredient, Integer> ingredients;
    private Integer totalCalories;
}
