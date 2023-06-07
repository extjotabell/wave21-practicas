package com.ejercicio.calculaCaloria.service;

import com.ejercicio.calculaCaloria.dto.IngredientDto;
import com.ejercicio.calculaCaloria.repository.IngredientRepository;
import com.ejercicio.calculaCaloria.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<IngredientDto> find(String query) {
        return ingredientRepository
                .findAllByNameContains(query)
                .stream().map(Mapper::DTOfromIngredient)
                .collect(Collectors.toList());
    }
}
