package com.example.ContadorCalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.ContadorCalorias.entity.Ingrediente;
import com.example.ContadorCalorias.entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class DishRepository {
    public List<Ingrediente> ingredientes = loadDataBase();

    Plato p = new Plato("Plato1", crearPlato());
    public List<Plato> platos = Arrays.asList(p);

    public Map<Ingrediente, Integer> crearPlato()
    {
        Map<Ingrediente, Integer> ingPlato = new HashMap<>();

        ingPlato.put(ingredientes.get(0),100);
        ingPlato.put(ingredientes.get(2), 50);

        return ingPlato;
    }

    private List<Ingrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ing = null;
        try {
            ing = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ing;
    }
}
