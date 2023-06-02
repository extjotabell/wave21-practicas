package com.calorias.calorias.Controller;

import com.calorias.calorias.Dto.DishRequestDTO;
import com.calorias.calorias.Dto.DishResponseDTO;
import com.calorias.calorias.Service.IDishService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {
    private IDishService _dishService;

    public DishController(IDishService dishService){
        this._dishService = dishService;
    }

    @GetMapping("plato")
    public DishResponseDTO getInfo(@RequestBody DishRequestDTO dish){
        return this._dishService.getInfoDish(dish);
    }

    @GetMapping("platos")
    public List<DishResponseDTO> getInfoDishes(@RequestBody List<DishRequestDTO> dishes){
        return this._dishService.getInfoDishes(dishes);
    }
}
