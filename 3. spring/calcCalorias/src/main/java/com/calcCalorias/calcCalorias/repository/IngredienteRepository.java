package com.calcCalorias.calcCalorias.repository;

import com.calcCalorias.calcCalorias.model.Ingrediente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class IngredienteRepository {

    List<Ingrediente> ingredientes = new ArrayList<>();

    public IngredienteRepository() {
        this.ingredientes = loadDataBase();
    }

    public List<Ingrediente> obtenerIngredientes(){
        return this.ingredientes;
    }

    public Ingrediente obtenerIngrediente(String nombre){
        return this.ingredientes.stream()
                .filter(ingredients1 -> ingredients1.getName().equals(nombre))
                .findFirst().orElse(null);
    }
    /*public Ingrediente obtenerIngrediente(String nombreIngrediente){
        return ingredientes.stream()
                .filter(ingrediente -> ingrediente.getName()
                        .equalsIgnoreCase(nombreIngrediente)).findFirst().orElseThrow();
    }*/

    private List<Ingrediente> loadDataBase() {
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
