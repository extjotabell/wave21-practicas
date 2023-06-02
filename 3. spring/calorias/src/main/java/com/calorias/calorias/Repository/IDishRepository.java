package com.calorias.calorias.Repository;

import com.calorias.calorias.Model.DishEntity;
import com.calorias.calorias.Model.FoodEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IDishRepository {
    DishEntity createDish(String name);
    Integer getTotalCalories();
    FoodEntity getIngredientWithMaxCalories();
}
