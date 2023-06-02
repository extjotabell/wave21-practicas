package com.calorias.calorias.Service;

import com.calorias.calorias.Dto.*;
import com.calorias.calorias.Model.DishEntity;
import com.calorias.calorias.Repository.IDishRepository;
import com.calorias.calorias.Repository.IFoodRepository;
import com.calorias.calorias.Dto.FoodResponseDTO;
import com.calorias.calorias.Model.FoodEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
@Service
public class DishServiceImpl implements IDishService {
    private IDishRepository _repository;
    private ModelMapper modelMapper;

    public DishServiceImpl(IDishRepository repository) {
        this._repository = repository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DishResponseDTO getInfoDish(DishRequestDTO dish) {
        DishResponseDTO response = new DishResponseDTO();
        DishEntity dishEntity = this._repository.createDish(dish.getName());
        response.setName(dish.getName());
        response.setIngredients(dishEntity.getIngredients().stream()
                .map(foodEntity -> modelMapper.map(foodEntity, FoodResponseDTO.class)).toList());
        response.setTotalCalories(this._repository.getTotalCalories() * dish.getWeightInGrams().intValue());
        response.setIngredientWithMaxCalories(modelMapper.map(this._repository.getIngredientWithMaxCalories(), FoodResponseDTO.class));
        return response;
    }

    @Override
    public List<DishResponseDTO> getInfoDishes(List<DishRequestDTO> dishes){
        return dishes.stream().map(this::getInfoDish).toList();
    }
}
