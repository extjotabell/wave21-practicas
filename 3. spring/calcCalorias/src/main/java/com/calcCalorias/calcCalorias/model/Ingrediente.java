package com.calcCalorias.calcCalorias.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ingrediente {
    String name;
    int calories;

    public Ingrediente(String name, int calorias) {
        this.name = name;
        this.calories = calorias;
    }

    public Ingrediente() {
    }
}
