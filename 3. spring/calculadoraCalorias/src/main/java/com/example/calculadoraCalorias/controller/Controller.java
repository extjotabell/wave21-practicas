package com.example.calculadoraCalorias.controller;

import com.example.calculadoraCalorias.dtos.ResponseDTO;
import com.example.calculadoraCalorias.services.IngredientesService;
import com.example.calculadoraCalorias.services.PlatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {


    @Autowired
    IngredientesService ingredientesService;
    PlatosService platosService;

    @GetMapping("/getIngredientes/{plato}/{gramos}")
    public List<ResponseEntity<ResponseDTO>> getListaIngredientes(@PathVariable String plato,
                                                                  @PathVariable int gramos ){

        ResponseDTO response = ingredientesService. ;

    }
}
