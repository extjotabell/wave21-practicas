package com.bootcamp.calorias.dto;

import com.bootcamp.calorias.model.Ingrediente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PlatoDTO {
    private List<Ingrediente> ingredients;
    private HashMap<Ingrediente,Integer> gramos;
    private String name;
    private int totalCalories;
    private Ingrediente ingredienteMasCalorico;


}
