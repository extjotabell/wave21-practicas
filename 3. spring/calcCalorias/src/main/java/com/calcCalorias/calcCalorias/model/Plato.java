package com.calcCalorias.calcCalorias.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Plato {
    String name;
    List<Ingrediente> ingredientes;

    public Plato(String name, List<Ingrediente> ingredientes) {
        this.name = name;
        this.ingredientes = ingredientes;
    }
}
