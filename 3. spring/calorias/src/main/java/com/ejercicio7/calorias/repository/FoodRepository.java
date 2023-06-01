package com.ejercicio7.calorias.repository;

import com.ejercicio7.calorias.entity.Ingredients;

import java.util.List;

public interface FoodRepository {
    List<Ingredients> findAllIngredients();
}
