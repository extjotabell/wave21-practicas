package com.example.ContadorCalorias.controller;

import com.example.ContadorCalorias.dto.dto_ingrediente;
import com.example.ContadorCalorias.dto.dto_platoCaloriasTotales;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.ContadorCalorias.service.ServicePlatos;

import java.util.List;

@RestController
public class Controller {
    ServicePlatos servicio;

    public Controller(ServicePlatos service) {
        this.servicio = service;
    }

    @GetMapping({"/dishCalories/{name}"})
    public ResponseEntity<dto_platoCaloriasTotales> calcularCaloriasTotales (@PathVariable String name)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.servicio.caloriasTotales(name));
    }

    @GetMapping({"/listIngredients/{name}"})
    public ResponseEntity<List<dto_ingrediente>> listodoDeIngredientes(@PathVariable String name)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(this.servicio.ingredientesDelPlato(name));
    }

    @GetMapping({"/mostCaloric/{name}"})
    public ResponseEntity<dto_ingrediente> ingredienteMasCalorico (@PathVariable String name)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(this.servicio.obtenerIngredienteMasCalorias(name));
    }
}
