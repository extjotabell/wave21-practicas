package com.bootcamp.calorias.service;

import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.model.Plato;
import com.bootcamp.calorias.repository.RepoPlato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService implements IPlatoService{
    RepoPlato repo ;

    public PlatoService(RepoPlato repo){
        this.repo = repo;
    }

    @Override
    public List<Plato> findAll() {
        return repo.findAll();
    }

    @Override
    public Plato findPlato(String name) {
        if(repo.findbyName(name.toUpperCase()) == null){
            return null;
        }
        return repo.findbyName(name.toUpperCase());
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }
}
