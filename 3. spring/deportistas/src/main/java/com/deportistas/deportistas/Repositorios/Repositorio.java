package com.deportistas.deportistas.Repositorios;

import com.deportistas.deportistas.DTOS.Deporte;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repositorio<T> {
    private ArrayList<T> repositorio;

    public Repositorio(){
        this.repositorio = new ArrayList<>();
    }

    public ArrayList<T> buscarTodos(){
        return this.repositorio;
    }

    public void agregar(T parametro){
        this.repositorio.add(parametro);
    }




}
