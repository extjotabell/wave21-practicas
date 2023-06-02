package com.calcCalorias.calcCalorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Plato {
    String name;
    List<Ingrediente> ingredientes;

    public Plato(String name, List<Ingrediente> ingredientes) {
        this.name = name;
        this.ingredientes = ingredientes;
    }
}
