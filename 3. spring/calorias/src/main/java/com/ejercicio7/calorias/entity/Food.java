package com.ejercicio7.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class Food {
    private String name;
    private Integer weight;
    private List<Ingredients> ingredients;
}
