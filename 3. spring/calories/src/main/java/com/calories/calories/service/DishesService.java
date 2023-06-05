package com.calories.calories.service;

import com.calories.calories.dto.response.DishDTO;
import com.calories.calories.dto.response.DishesAllDTO;
import com.calories.calories.model.Dish;
import com.calories.calories.model.Ingredient;
import com.calories.calories.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DishesService {

    DishRepository repository;

    public DishesService(DishRepository repository) {
        this.repository = repository;
    }

    public List<DishesAllDTO> dishList(){

        List<Dish> dishes = repository.getDishes();
        List<DishesAllDTO> dishesDTO = new ArrayList<>();
        for (Dish dish: dishes) {
            DishesAllDTO dishDTO = new DishesAllDTO(dish.getName(),dish.getGrams(),dish.getIngredients());
            dishesDTO.add(dishDTO);
        }
        return dishesDTO;
    }

    public DishDTO findDish(String name){
        Dish dish = repository.getDish(name);
        int totCalories = dish.getIngredients().stream().mapToInt(Ingredient::getCalories).sum();
        Ingredient ingredientMaxCalories = dish.getIngredients().stream()
                .max(Comparator.comparingInt(Ingredient::getCalories))
                .orElse(null);
        DishDTO dishDTO = new DishDTO(dish.getName(),totCalories,dish.getIngredients(),ingredientMaxCalories);
        System.out.println(dishDTO);
        return dishDTO;
    }

}
