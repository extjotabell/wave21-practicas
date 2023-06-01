package com.bootcamp.calculadoradecalorias.repository;

import com.bootcamp.calculadoradecalorias.model.Ingredient;

import java.util.List;

public interface IIngredientsRepository {
    public List<Ingredient> getIngredients();
}
