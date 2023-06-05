package com.calories.calories.repository;

import com.calories.calories.model.Dish;
import com.calories.calories.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DishRepository {

    IngredientRepository repository;
    private List<Dish> dishes = new ArrayList<>();

    public DishRepository(IngredientRepository repository) {
        this.repository = repository;
        setDishes();
    }

    public List<Dish> getDishes(){
        return dishes;
    }

    public Dish getDish(String name){
        return dishes.stream()
                .filter(dish -> dish.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private void setDishes(){

        List<Ingredient> ingredientsDish1 = Arrays.asList(repository.findIngredient("Aceitunas negras"),repository.findIngredient("Tomates"),repository.findIngredient("Piña"),repository.findIngredient("Harina de maíz"));
        Dish dish1 = new Dish("Pizza",300,ingredientsDish1);

        List<Ingredient> ingredientsDish2 = Arrays.asList(repository.findIngredient("Aceitunas negras"),repository.findIngredient("Tomates"),repository.findIngredient("Cebolla"),repository.findIngredient("Aceite de oliva"));
        Dish dish2 = new Dish("Ensalada",100,ingredientsDish1);

        dishes.add(dish1);
        dishes.add(dish2);

    }

}
