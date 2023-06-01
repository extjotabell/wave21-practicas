package com.example.calories.controller;

import com.example.calories.dto.IngredientDto;
import com.example.calories.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    @PostMapping("/save")
    public ResponseEntity<String> saveList(@RequestBody ArrayList<IngredientDto> list){
        return calculatorService.saveAllIngredients(list);
    }
}
