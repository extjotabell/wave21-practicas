package com.ejercicio7.calorias.service.impl;

import com.ejercicio7.calorias.dto.FoodDTO;
import com.ejercicio7.calorias.entity.Food;
import com.ejercicio7.calorias.entity.Ingredients;
import com.ejercicio7.calorias.repository.FoodRepository;
import com.ejercicio7.calorias.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public FoodDTO getFood(String name, Integer weight) {
        List<Food> foods= loadFood();

        Food filteredFood = foods.stream().filter(foodDTO -> foodDTO.getName().equals(name) && foodDTO.getWeight().equals(weight)).findFirst().orElse(null);

        if(filteredFood!=null)
            return new FoodDTO(getTotalCalories(filteredFood)
                    , maxCalorie(filteredFood),
                    filteredFood.getIngredients());

        return null;
    }

    private static Integer getTotalCalories(Food filteredFood) {
        return filteredFood.getIngredients().stream().map(ingredients -> ingredients.getCalories())
                .reduce((integer, integer2) -> integer + integer2).orElse(null);
    }

    private static Ingredients maxCalorie(Food filteredFood) {
        return filteredFood.getIngredients().stream().max(Comparator.comparing(Ingredients::getCalories)).orElse(null);
    }


    private List<Food> loadFood(){
        Food comida1= new Food("Hamburguesa",34, Arrays.asList(obtenerIngrediente("Hamburguesa"),obtenerIngrediente("Lechuga"),obtenerIngrediente("Queso cheddar")));
        Food comida2= new Food("Ensalada de frutas",33,Arrays.asList(obtenerIngrediente("Ciruela"),obtenerIngrediente("Cereza"),obtenerIngrediente("Naranja")));

        return Arrays.asList(comida1,comida2);
    }

    private Ingredients obtenerIngrediente(String nombre){
        return foodRepository.findAllIngredients().stream()
                .filter(ingredients1 -> ingredients1.getName().equals(nombre))
                .findFirst().orElse(null);
    }
}
