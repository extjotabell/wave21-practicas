package com.ejercicio.calculaCaloria.controller;


import com.ejercicio.calculaCaloria.dto.IngredientDto;
import com.ejercicio.calculaCaloria.dto.PlateDto;
import com.ejercicio.calculaCaloria.service.IngredientService;
import com.ejercicio.calculaCaloria.service.PlateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlateController {

    PlateService plateService;
    IngredientService ingredientService;

    public PlateController(PlateService plateService, IngredientService ingredientService) {
        this.plateService = plateService;
        this.ingredientService = ingredientService;
    }

    @PostMapping("/plate")
    public ResponseEntity<PlateDto> getPlateInfo(@RequestBody String name){
        return ResponseEntity.ok(plateService.getPlate(name));
    }

    @GetMapping("/ingredient/{query}")
    public List<IngredientDto> find(@PathVariable String query) {
        return ingredientService.find(query);
    }
}
