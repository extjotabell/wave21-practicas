package com.calorias.calorias.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class Plato {
    private String name;
    private List<Food> ingredients;

    public Plato(String name, List<Food> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
}
