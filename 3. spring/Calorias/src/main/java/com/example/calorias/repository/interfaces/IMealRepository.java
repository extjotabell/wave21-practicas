package com.example.calorias.repository.interfaces;

import com.example.calorias.model.Meal;

public interface IMealRepository {
    Meal getMealByNameAndWeight(String name, Integer weight);
}
