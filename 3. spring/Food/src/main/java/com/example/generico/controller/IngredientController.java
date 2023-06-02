package com.example.generico.controller;

import com.example.generico.DTO.IngredientResponseDto;
import com.example.generico.entity.Ingredient;
import com.example.generico.service.IngredientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {

  @Autowired
  IngredientService ingredientService;

  @GetMapping("/ingrediente/{id}")
  public ResponseEntity<IngredientResponseDto> getIngredients(@PathVariable final Integer id) {
    var ingredient = ingredientService.getiIngredient(id);

    return new ResponseEntity<>(ingredient, HttpStatus.OK);
  }

  @GetMapping("/ingredientes")
  public ResponseEntity<List<IngredientResponseDto>> getIngredients() {

    var ingredient =  ingredientService.getAll();

    return new ResponseEntity<>(ingredient, HttpStatus.OK);
  }
}
