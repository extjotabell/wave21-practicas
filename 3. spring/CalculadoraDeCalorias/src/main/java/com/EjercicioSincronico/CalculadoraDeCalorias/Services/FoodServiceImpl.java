package com.EjercicioSincronico.CalculadoraDeCalorias.Services;

import com.EjercicioSincronico.CalculadoraDeCalorias.DTOs.*;
import com.EjercicioSincronico.CalculadoraDeCalorias.Models.Ingredient;
import com.EjercicioSincronico.CalculadoraDeCalorias.Repository.IFoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService {
    private final IFoodRepository _foodRepository;

    public FoodServiceImpl(IFoodRepository _foodRepository) {
        this._foodRepository = _foodRepository;
    }

    public DishResponseDTO calculateCalories(DishDTO dish){
        DishResponseDTO result = new DishResponseDTO(dish);

        int total = 0;
        int maxCalories = 0;

        for (IngredientDTO ingredient : result.getIngredients()) {
            // Calculo las calorias de un ingrediente
            calculateIngredientCalories(ingredient);

            // Las sumo para obtener las calorias total del plato
            total += ingredient.getCalories();

            // Calculo para saber cual es el ingrediente con mas calorias
            if (ingredient.getCalories() > maxCalories){
                result.setCaloric(ingredient);
                maxCalories = ingredient.getCalories();
            }
        }
        result.setCalories(total);
        return result;
    }

    @Override
    public List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes) {
        List<DishResponseDTO> result = new ArrayList<>();
        for (DishDTO dish : dishes) {
            result.add(this.calculateCalories(dish));
        }
        return result;
    }

    private void calculateIngredientCalories(IngredientDTO ingredient) {
        Ingredient ingredientRepository = _foodRepository.getIngredientsByName(ingredient.getName());
        if (ingredientRepository != null)
            ingredient.setCalories(ingredientRepository.calculateCalories(ingredient.getWeight()));
    }
}
