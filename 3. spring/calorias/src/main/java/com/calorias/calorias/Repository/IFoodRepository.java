package com.calorias.calorias.Repository;

import com.calorias.calorias.Dto.DishRequestDTO;
import com.calorias.calorias.Model.FoodEntity;

import java.util.List;

public interface IFoodRepository {
    List<FoodEntity> getFoods();

}
