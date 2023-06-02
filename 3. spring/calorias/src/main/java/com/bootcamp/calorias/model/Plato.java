package com.bootcamp.calorias.model;

import com.bootcamp.calorias.dto.PlatoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor

public class Plato {

    private List<Ingrediente> ingredients;
    private String name;
    private HashMap<Ingrediente,Integer> cantidadGramos;
    private int totalCalories;

    public Plato(String name, List<Ingrediente> ingredientes){
        this.name = name;
        this.ingredients = ingredientes;
        this.cantidadGramos = new HashMap<>();
    }

    public void agregarGramos(Ingrediente ing, Integer gramos){
        cantidadGramos.put(ing,gramos);
    }
    public int calcularCalorias(){
    int totalCalorias = 0;
        for (Map.Entry<Ingrediente, Integer> entry : cantidadGramos.entrySet()) {
            totalCalorias += (entry.getValue() / 100) * entry.getKey().getCalories() ;
        }
        return totalCalorias;
    }

    public Ingrediente ingredienteMasCalorico(){
        return ingredients.stream().max(Comparator.comparingInt(Ingrediente::getCalories)).get();
    }


}
