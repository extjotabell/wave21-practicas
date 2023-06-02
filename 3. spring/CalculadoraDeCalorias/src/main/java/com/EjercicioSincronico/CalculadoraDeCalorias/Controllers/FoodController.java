package com.EjercicioSincronico.CalculadoraDeCalorias.Controllers;

import com.EjercicioSincronico.CalculadoraDeCalorias.DTOs.DishDTO;
import com.EjercicioSincronico.CalculadoraDeCalorias.DTOs.DishResponseDTO;
import com.EjercicioSincronico.CalculadoraDeCalorias.Services.IFoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class FoodController {
    private final IFoodService _foodService;

    public FoodController(IFoodService _foodService) {
        this._foodService = _foodService;
    }

    @PostMapping("calculateDish")
    public ResponseEntity<?> calculateCaloriesByDish(@RequestBody DishDTO dish){
        HttpStatus status = HttpStatus.OK;

        var result = _foodService.calculateCalories(dish);

        return ResponseEntity.status(status).body(result);
    }

    @PostMapping("/calculateAllDishes")
    public List<DishResponseDTO> calculateCaloriesByListOfDishes(@RequestBody List<DishDTO> dishes){
        return _foodService.calculateAllCalories(dishes);
    }
}

