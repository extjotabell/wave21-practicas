package com.calcCalorias.calcCalorias.repository.impl;

import com.calcCalorias.calcCalorias.model.Ingrediente;
import com.calcCalorias.calcCalorias.repository.IngredienteRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository {

    private List<Ingrediente> ingredientes;

    public IngredienteRepositoryImpl(){
        this.ingredientes=loadDataBase();
    }

    @Override
    public List<Ingrediente> obtenerIngredientes(){
        return this.ingredientes;
    }

    public Ingrediente obtenerIngrediente(String nombre){
        return this.ingredientes.stream()
                .filter(ingredients1 -> ingredients1.equals(nombre))
                .findFirst().orElse(null);
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
        List<Ingrediente> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
