package com.ejercicio.calculaCaloria.utils;

import com.ejercicio.calculaCaloria.dto.IngredientDto;
import com.ejercicio.calculaCaloria.dto.PlateDto;
import com.ejercicio.calculaCaloria.model.Ingredient;
import com.ejercicio.calculaCaloria.model.Plate;

public class Mapper {

    public static IngredientDto DTOfromIngredient(Ingredient ingredient){
        return new IngredientDto(ingredient.getName(), ingredient.getCalories());
    }

}
