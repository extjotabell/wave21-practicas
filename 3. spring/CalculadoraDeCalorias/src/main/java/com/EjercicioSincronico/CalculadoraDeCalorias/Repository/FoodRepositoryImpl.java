package com.EjercicioSincronico.CalculadoraDeCalorias.Repository;

import com.EjercicioSincronico.CalculadoraDeCalorias.Models.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {
    private static final String JSON_PATH = "classpath:food.json";
    private final List<Ingredient> data;

    public FoodRepositoryImpl(List<Ingredient> data) {
        this.data = loadJsonData();
    }

    @Override
    public List<Ingredient> getIngredientsByName(List<String> name) {
        return data.stream()
                .filter(x-> name.contains(x.getName()))
                .toList();
    }

    @Override
    public Ingredient getIngredientsByName(String name) {
        Optional<Ingredient> ingredient = data.stream()
                .filter(x-> x.getName().equalsIgnoreCase(name))
                .findFirst();

        Ingredient result = null;
        if (ingredient.isPresent()){
            result = ingredient.get();
        }

        return result;
    }

    private List<Ingredient> loadJsonData() {
        File file = new File(JSON_PATH);
        try{
            file = ResourceUtils.getFile(JSON_PATH);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeReference = new TypeReference<List<Ingredient>>() {};
        List<Ingredient> ingredients = null;

        try {
            ingredients = mapper.readValue(file, typeReference);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return ingredients;
    }


}
