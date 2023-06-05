package com.example.calorias.controller;

import com.example.calorias.dto.IngredientDTO;
import com.example.calorias.service.interfaces.IMealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("meal")
public class MealController {
    private IMealService mealService;

    public MealController(IMealService mealService){
        this.mealService = mealService;
    }
    @GetMapping("calories/{name}/{weight}")
    public ResponseEntity<Integer> getCalories(@PathVariable String name, @PathVariable Integer weight){
        return ResponseEntity.ok(mealService.getCalories(name, weight));
    }

    @GetMapping("ingredients/{name}/{weight}")
    public ResponseEntity<List<IngredientDTO>> getIngredients(@PathVariable String name, @PathVariable Integer weight){

    }
}
