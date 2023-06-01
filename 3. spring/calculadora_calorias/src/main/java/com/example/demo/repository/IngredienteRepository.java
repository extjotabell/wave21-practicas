package com.example.demo.repository;

import com.example.demo.model.Ingrediente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredienteRepository {

    List<Ingrediente> ingredientes = new ArrayList<>();

    public IngredienteRepository(){
        ingredientes = load();
    }

    public List<Ingrediente> findAll(){
        return ingredientes;
    }

    public Ingrediente findIngrediente(String nombreIngrediente){
        return ingredientes.stream()
                .filter(ingrediente -> ingrediente.getName()
                        .equalsIgnoreCase(nombreIngrediente)).findFirst()
                .orElse(null);
    }

    private List<Ingrediente> load() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try {
            File jsonFile = ResourceUtils.getFile("classpath:food.json");
            return objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (
                JsonProcessingException e) {
            System.out.println("Mal formateo de JSON");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("No se pudo leer archivo el json");
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
