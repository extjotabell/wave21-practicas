package com.ejercicio.calculaCaloria.repository;

import com.ejercicio.calculaCaloria.model.Ingredient;
import com.ejercicio.calculaCaloria.model.Plate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PlateRepository {
    private List<Plate> plates;
    IngredientRepository ingredientRepository;
    // private List<Person> people;


    public PlateRepository(List<Plate> plates, IngredientRepository ingredientRepository) {
        this.plates = plates;
        this.ingredientRepository = ingredientRepository;
        initData();
    }

    public Plate findByName(String name){
        Plate plate = plates.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
        return plate;
    }

    private void initData() {
        List<Ingredient> ingredientList = ingredientRepository.getDatabase();
        Plate pastelDeChoclo = new Plate("Pastel de choclo", 1000, Arrays.asList(ingredientList.get(0), ingredientList.get(1)));
        Plate humita = new Plate("Humita", 700, Arrays.asList(ingredientList.get(3), ingredientList.get(4)));
        Plate pasta = new Plate("Pasta bolognesa", 800, Arrays.asList(ingredientList.get(5), ingredientList.get(6)));

        this.plates.addAll(Arrays.asList(pastelDeChoclo, humita, pasta));
    }

}
