package com.calories.calories.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Dish {

    private String name;
    private int grams;
    private List<Ingredient> ingredients;

}
