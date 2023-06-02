package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.model.Plato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@org.springframework.stereotype.Repository
public class RepoPlato implements Repository<Plato> {
    List<Plato> platos;

    public RepoPlato(){
        this.platos = new ArrayList<>();
        crearPlatos();
    }
    @Override
    public List<Plato> findAll() {
        return this.platos;
    }

    @Override
    public Plato findbyName(String name) {

        return this.platos.stream().filter(n-> n.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void add(Plato obj) {

    }

    @Override
    public void delete(Plato obj) {

    }

    public void crearPlatos(){
        RepoCalorias calorias = new RepoCalorias();
        Ingrediente ingrediente1 = new Ingrediente(calorias.ingredientes.get(4));
        Ingrediente ingrediente2 = new Ingrediente(calorias.ingredientes.get(2));
        Ingrediente ingrediente3 = new Ingrediente(calorias.ingredientes.get(0));
        Ingrediente ingrediente4 = new Ingrediente(calorias.ingredientes.get(5));
        Plato plato1  = new Plato("SOPA",new ArrayList<>(Arrays.asList(ingrediente1,ingrediente3)));
        Plato plato2 = new Plato("TARTA", new ArrayList<>(Arrays.asList(ingrediente2,ingrediente3,ingrediente4)));
        Plato plato3 = new Plato("PIONONO", new ArrayList<>(Arrays.asList(ingrediente1, ingrediente2,ingrediente4)));
        plato1.agregarGramos(plato1.getIngredients().get(0),100);
        plato1.agregarGramos(plato1.getIngredients().get(1),200);
        plato2.agregarGramos(plato2.getIngredients().get(0),350);
        plato2.agregarGramos(plato2.getIngredients().get(1),400);
        plato2.agregarGramos(plato2.getIngredients().get(2),100);
        plato3.agregarGramos(plato3.getIngredients().get(0),250);
        plato3.agregarGramos(plato3.getIngredients().get(1),100);
        plato3.agregarGramos(plato3.getIngredients().get(2),200);

        platos.addAll(Arrays.asList(plato1,plato2,plato3));
    }
}
