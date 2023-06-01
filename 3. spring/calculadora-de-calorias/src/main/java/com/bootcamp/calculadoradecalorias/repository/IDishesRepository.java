package com.bootcamp.calculadoradecalorias.repository;

import com.bootcamp.calculadoradecalorias.model.Dish;

import java.util.List;

public interface IDishesRepository {
    public List<Dish> dishes();
}
