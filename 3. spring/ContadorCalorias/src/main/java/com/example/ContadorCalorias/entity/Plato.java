package com.example.ContadorCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Plato {
    private String name;
    private Map<Ingrediente, Integer> indredients; //Esto es para tener el peso de cuánto ingrediente se necesita para el plato

    public int totalCalories()
    {
        int resultado = 0;
        for(Map.Entry<Ingrediente, Integer> entry : this.indredients.entrySet())
        {
            Ingrediente i = entry.getKey();
            Integer quantity = entry.getValue();
            resultado = resultado + ((quantity * i.getCalories() / 100));
        }

        return resultado;
    }
}
