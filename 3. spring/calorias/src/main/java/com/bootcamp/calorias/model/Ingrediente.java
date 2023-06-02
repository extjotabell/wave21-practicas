package com.bootcamp.calorias.model;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Ingrediente {
    private String name;
    private int calories;

    public Ingrediente(){}

    public Ingrediente(Ingrediente ingrediente){
        this.name = ingrediente.getName();
        this.calories = ingrediente.getCalories();
    }

}
