package com.calorias.calorias.controller;

import com.calorias.calorias.model.Food;
import com.calorias.calorias.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;


    @GetMapping("/Plato")
    public ResponseEntity<Integer> findCaloriesPlato(@RequestParam(required = false)  String name, @RequestParam(required = false)  Integer peso){
        return new ResponseEntity<Integer>(foodService.obtenerCalorias(name, peso), HttpStatus.OK);
    }

    @GetMapping("/listarIngredientes/{name}")
    public ResponseEntity<List<Food>> listarIngredientes(@PathVariable String name){
        return new ResponseEntity<>(foodService.listaFood(name), HttpStatus.OK);
    }

    @GetMapping("/ingredienteCalorico/{name}")
    public ResponseEntity<Food> obtenerIngredienteCalorico(@PathVariable String name){
        return new ResponseEntity<>(foodService.getFoodMaxCalories(name), HttpStatus.OK);
    }
}
