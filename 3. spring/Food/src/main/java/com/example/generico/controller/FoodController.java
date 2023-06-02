package com.example.generico.controller;

import com.example.generico.DTO.FoodDto;
import com.example.generico.DTO.FoodIdDto;
import com.example.generico.DTO.FoodResponseDto;
import com.example.generico.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
  @Autowired
  FoodService foodService;

  @GetMapping("/food/{name}")
  public ResponseEntity<FoodResponseDto> getFood(final @PathVariable String name) {
    final FoodResponseDto f = foodService.findFoodByName(name);

    return new ResponseEntity<>(f, HttpStatus.OK);
  }

  @PostMapping("/food")
  public ResponseEntity<FoodIdDto> createFood(@RequestBody final FoodDto food) {
    final FoodIdDto f = foodService.createFood(food);

    return new ResponseEntity<>(f, HttpStatus.OK);

  }
}
