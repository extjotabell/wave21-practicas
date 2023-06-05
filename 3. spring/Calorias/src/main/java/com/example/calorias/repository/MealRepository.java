package com.example.calorias.repository;

import com.example.calorias.model.Meal;
import com.example.calorias.repository.interfaces.IMealRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealRepository implements IMealRepository {
    public List<Meal> meals = new ArrayList<>();
    @Override
    public Meal getMealByNameAndWeight(String name, Integer weight) {
        return meals.stream()
                .filter(meal -> meal.getName().equals(name) && meal.getWight().equals(weight))
                .findFirst()
                .orElse(null);
    }
}
