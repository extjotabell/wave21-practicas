package com.calorias.calorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food {
    private String name;
    private int calories;

    public void getName(String name) {
        this.name = name;
    }

    public void getCalories(int calories) {
        this.calories = calories;
    }
}