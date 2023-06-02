package com.calorias.calorias.Service;

import com.calorias.calorias.Dto.*;
import com.calorias.calorias.Dto.FoodResponseDTO;

import java.util.List;

public interface IDishService {
    DishResponseDTO getInfoDish(DishRequestDTO ingredients);
    List<DishResponseDTO> getInfoDishes(List<DishRequestDTO> dishes);
}
