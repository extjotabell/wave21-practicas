package com.bootcamp.calculadoradecalorias.repository;

import com.bootcamp.calculadoradecalorias.model.Dish;
import com.bootcamp.calculadoradecalorias.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DishesRepository implements IDishesRepository {

    @Autowired
    IIngredientsRepository ingredientsRepository;

    @Override
    public List<Dish> dishes() {
        List<Dish> dishes = new ArrayList<>();

        List<Ingredient> ingredients = ingredientsRepository.getIngredients();

        dishes.add(new Dish("Pizza", Arrays.asList(ingredients.get(0),ingredients.get(1)), 10));
        dishes.add(new Dish("Hamburger", Arrays.asList(ingredients.get(3),ingredients.get(4),ingredients.get(5)), 9));
        dishes.add(new Dish("Hot Dog", Arrays.asList(ingredients.get(2),ingredients.get(7)), 8));
        dishes.add(new Dish("Fried Chicken", Arrays.asList(ingredients.get(1),ingredients.get(2), ingredients.get(3)), 11));
        dishes.add(new Dish("Lasagna", Arrays.asList(ingredients.get(5), ingredients.get(6), ingredients.get(7)), 7));
        
        return dishes;
    }
}
