package com.example.calories.service;

import com.example.calories.dto.IngredientDto;
import com.example.calories.model.Ingredient;
import com.example.calories.repository.CalculatorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Autowired
    CalculatorRepository repository;

    @Override
    public ResponseEntity<String> saveAllIngredients(List<IngredientDto> dto) {
        ModelMapper modelMapper = new ModelMapper();
        List<Ingredient> model = dto.stream()
                .map(i -> {
                    Ingredient ingredient = modelMapper.map(i, Ingredient.class);
                    return ingredient;
                })
                .toList();
        if(repository.saveIngredients(model)){
            return ResponseEntity.ok("Carga de ingredientes exitosa");
        }
        else return new ResponseEntity<>("Ocurrio un problema.", HttpStatus.CONFLICT);
    }
}
