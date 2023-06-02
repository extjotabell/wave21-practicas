package com.bootcamp.calorias.service;

import com.bootcamp.calorias.model.Ingrediente;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IIngredienteService {

    public List<Ingrediente> findAll();
    public void add();
    public void delete();


}
