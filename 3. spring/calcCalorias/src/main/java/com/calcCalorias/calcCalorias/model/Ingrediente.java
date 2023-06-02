package com.calcCalorias.calcCalorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingrediente {
    String name;
    int calorias;

    public Ingrediente(String name, int calorias) {
        this.name = name;
        this.calorias = calorias;
    }
}
