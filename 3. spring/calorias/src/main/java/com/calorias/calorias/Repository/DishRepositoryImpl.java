package com.calorias.calorias.Repository;

import com.calorias.calorias.Dto.FoodResponseDTO;
import com.calorias.calorias.Model.DishEntity;
import com.calorias.calorias.Model.FoodEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Repository
public class DishRepositoryImpl implements IDishRepository{
    private IFoodRepository _foodRepository;
    private List<FoodEntity> ingredients;

    public DishRepositoryImpl(IFoodRepository foodRepository){
        this._foodRepository = foodRepository;
        this.ingredients = new ArrayList<>();
    }
    @Override
    public DishEntity createDish(String name) {
        Random random = new Random();
        int numIngredients = random.nextInt(5) + 3;
        random.ints(numIngredients, 0, this._foodRepository.getFoods().size())
                .mapToObj(this._foodRepository.getFoods()::get)
                .forEach(ingredients::add);
        return new DishEntity(name, ingredients);
    }

    @Override
    public Integer getTotalCalories(){
        return this.ingredients.stream().mapToInt(FoodEntity::getCalories).sum();
    }

    @Override
    public FoodEntity getIngredientWithMaxCalories(){
        return this.ingredients.stream().max(Comparator.comparingInt(FoodEntity::getCalories)).orElse(null);
    }
}
