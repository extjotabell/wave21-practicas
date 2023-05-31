package com.ejercicioVivo.covid.service;

public class Sintoma {
    private String nombre;
    private int codigo;
    private int nivelDeGravedad;

    public Sintoma(String nombre, int codigo, int nivelDeGravedad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public int getCodigo() {
        return codigo;
    }
}
