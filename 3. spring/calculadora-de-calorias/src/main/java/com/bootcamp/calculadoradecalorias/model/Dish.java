package com.bootcamp.calculadoradecalorias.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Dish {

    private String name;
    private List<Ingredient> ingredients;
    private double calories;
    private double price;

    public Dish(){
        calculateCalories();
    }

    public Dish(String name, List<Ingredient> ingredients, double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        calculateCalories();
    }

    private void calculateCalories(){
        calories = 0;
        ingredients.forEach(ingredient -> {
            calories += ingredient.getCalories();
        });
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        calculateCalories();
    }
}