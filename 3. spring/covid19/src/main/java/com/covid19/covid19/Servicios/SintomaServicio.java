package com.covid19.covid19.Servicios;

import com.covid19.covid19.DTOS.Sintoma;
import com.covid19.covid19.Repositorios.Repositorio;

import java.util.ArrayList;

public class SintomaServicio {
    private final Repositorio<Sintoma> repositorio;

    public SintomaServicio(){
        this.repositorio = new Repositorio<>();
    }

    public ArrayList<Sintoma> obtenerSintomas(){
        return repositorio.obtenerRepositorio();
    }

    public Sintoma obtenerPorNombre(String nombre){
        return repositorio.obtenerRepositorio().stream().filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }

    public void agregarSintoma(Sintoma sintoma) {
        repositorio.agregar(sintoma);
    }
}
