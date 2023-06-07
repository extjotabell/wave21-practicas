package com.ejercicio.calculaCaloria.service;

import com.ejercicio.calculaCaloria.dto.PlateDto;
import com.ejercicio.calculaCaloria.model.Ingredient;
import com.ejercicio.calculaCaloria.model.Plate;
import com.ejercicio.calculaCaloria.repository.PlateRepository;
import com.ejercicio.calculaCaloria.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PlateService {

    PlateRepository repository;

    public PlateService(PlateRepository repository) {
        this.repository = repository;
    }

    public PlateDto getPlate(String name){
        // entidad
        Plate plate = repository.findByName(name);
        // conversion a dto
        PlateDto plateDto = new PlateDto();
        plateDto.setIngredientList(
                plate
                        .getIngredientList()
                        .stream()
                        .map(Mapper::DTOfromIngredient)
                        .collect(Collectors.toList())
        );
        plateDto.setName(plate.getName());
        plateDto.setCalories(plate.getCalories());
        plateDto.setMaxCalorieIngredient(plate.getMaxCalorieIngredient());
        return plateDto;
    }
}
