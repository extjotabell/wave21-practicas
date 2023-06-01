package com.ejercicio7.calorias.controller;

import com.ejercicio7.calorias.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calories")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("")
    public ResponseEntity<?> viewCalories(@RequestParam(value = "name") String name,
                                          @RequestParam(value = "weight") Integer weight){
        return ResponseEntity.ok(foodService.getFood(name,weight));
    }
}
