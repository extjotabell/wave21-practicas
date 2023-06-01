package com.example.calories.service;

import com.example.calories.dto.IngredientDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CalculatorService {
    public ResponseEntity<String> saveAllIngredients(List<IngredientDto> dto);
}
