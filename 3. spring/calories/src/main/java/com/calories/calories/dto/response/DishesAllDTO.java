package com.calories.calories.dto.response;

import com.calories.calories.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DishesAllDTO {

    private String name;
    private int grams;
    private List<Ingredient> ingredients;

}
