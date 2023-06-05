package com.example.calorias.service;

import com.example.calorias.dto.IngredientDTO;
import com.example.calorias.repository.interfaces.IIngredientRepository;
import com.example.calorias.repository.interfaces.IMealRepository;
import com.example.calorias.service.interfaces.IMealService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService implements IMealService {
    private IMealRepository mealRepository;
    private IIngredientRepository ingredientRepository;
    private ModelMapper modelMapper;

    public MealService(IMealRepository mealRepository, IIngredientRepository ingredientRepository, ModelMapper modelMapper){
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Integer getCalories(String name, Integer weight) {
        return mealRepository.getMealByNameAndWeight(name, weight).getTotalCalories();
    }

    @Override
    public List<IngredientDTO> getIngredients(String name, Integer weight) {
        return mealRepository.getMealByNameAndWeight(name, weight)
                .getIngredients()
                .stream()
                .map(ingredient -> modelMapper.map(ingredient, IngredientDTO.class))
                .collect(Collectors.toList());
    }
}
