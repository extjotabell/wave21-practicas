package com.covid19.covid19.Repositorios;

import java.util.ArrayList;

public class Repositorio<T> {
    private ArrayList<T> repositorio;

    public Repositorio(){
        this.repositorio = new ArrayList<>();
    }

    public ArrayList<T> obtenerRepositorio() {
        return this.repositorio;
    }

    public void agregar(T parametro) {
        this.repositorio.add(parametro);
    }
}
