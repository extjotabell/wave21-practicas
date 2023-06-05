package com.example.calculadoraCalorias.entitys;

import java.util.ArrayList;
import java.util.List;

public class Plato {

    private String nombrePlato;
    private List<Ingrediente> listaIngredientes;
    private int totalCalorias;


    public Plato() {

    }

    public Plato(String nombrePlato, List<Ingrediente> listaIngredientes) {
        this.nombrePlato = nombrePlato;
        this.listaIngredientes = listaIngredientes;
        totalCalorias = calcularCalorias(listaIngredientes);
    }


    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }


    public int calcularCalorias(List<Ingrediente> list ){
        int total = 0;

        for(Ingrediente ingrediente: list ){
            total+= ingrediente.getCalories();
        }
        return total;
    }
}
