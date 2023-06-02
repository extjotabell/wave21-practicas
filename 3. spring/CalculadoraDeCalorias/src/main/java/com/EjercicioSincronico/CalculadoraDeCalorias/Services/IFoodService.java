package com.EjercicioSincronico.CalculadoraDeCalorias.Services;

import com.EjercicioSincronico.CalculadoraDeCalorias.DTOs.DishDTO;
import com.EjercicioSincronico.CalculadoraDeCalorias.DTOs.DishResponseDTO;

import java.util.List;

public interface IFoodService {
    List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes);
    DishResponseDTO calculateCalories(DishDTO dish);
}
