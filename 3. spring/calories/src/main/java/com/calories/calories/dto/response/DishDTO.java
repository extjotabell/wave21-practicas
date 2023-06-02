package com.calories.calories.dto.response;

import com.calories.calories.model.Ingredient;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DishDTO {

    private String name;
    private int totCalories;
    private List<Ingredient> ingredients;
    private Ingredient ingredientMaxCalorie;

}
