package com.calories.calories.controller;

import com.calories.calories.dto.response.DishDTO;
import com.calories.calories.dto.response.DishesAllDTO;
import com.calories.calories.service.DishesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {

    DishesService service;

    public DishController(DishesService service) {
        this.service = service;
    }

    @GetMapping("/allDishes")
    public ResponseEntity<List<DishesAllDTO>> getDishes(){
        return new ResponseEntity<>(service.dishList(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DishDTO> getDishName(@PathVariable String name){
        return new ResponseEntity<>(service.findDish(name), HttpStatus.OK);
    }

}
