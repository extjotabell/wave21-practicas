package com.bootcamp.calorias.service;

import com.bootcamp.calorias.model.Plato;

import java.util.List;

public interface IPlatoService {
    public List<Plato> findAll();
    public Plato findPlato(String name);
    public void add();
    public void delete();
}
