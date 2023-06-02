package com.bootcamp.calorias.service;

import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.repository.RepoCalorias;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteServiceImpl implements IIngredienteService {

    RepoCalorias repo;

    public IngredienteServiceImpl(RepoCalorias repo){
        this.repo = repo;
    }

    @Override
    public List<Ingrediente> findAll() {
        return repo.findAll();
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
