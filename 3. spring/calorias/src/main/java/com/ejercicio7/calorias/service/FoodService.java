package com.ejercicio7.calorias.service;

import com.ejercicio7.calorias.dto.FoodDTO;

public interface FoodService {
    FoodDTO getFood(String name,Integer weight);
}
