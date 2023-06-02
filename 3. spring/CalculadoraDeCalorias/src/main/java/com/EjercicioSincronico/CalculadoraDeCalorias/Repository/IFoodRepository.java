package com.EjercicioSincronico.CalculadoraDeCalorias.Repository;

import com.EjercicioSincronico.CalculadoraDeCalorias.Models.Ingredient;

import java.util.List;

public interface IFoodRepository {
    List<Ingredient> getIngredientsByName(List<String> name);

    Ingredient getIngredientsByName(String name);
}
