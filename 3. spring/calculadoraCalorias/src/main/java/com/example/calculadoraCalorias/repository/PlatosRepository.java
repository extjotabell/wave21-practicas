package com.example.calculadoraCalorias.repository;

import com.example.calculadoraCalorias.entitys.Ingrediente;
import com.example.calculadoraCalorias.entitys.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class PlatosRepository {
    @Autowired
            IngredientesRepository ingredientesRepository;


    List<Plato> listaPlatos = new ArrayList<>();


    PlatosRepository(){
        listaPlatos = ingredientesRepository.getListaPlatos();

    }



}
