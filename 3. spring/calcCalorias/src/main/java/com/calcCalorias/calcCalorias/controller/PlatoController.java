package com.calcCalorias.calcCalorias.controller;

import com.calcCalorias.calcCalorias.model.Ingrediente;
import com.calcCalorias.calcCalorias.service.PlatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatoController {


    PlatoService platoService;

    public PlatoController(PlatoService platoService){
        this.platoService = platoService;
    }


    @GetMapping("cantidadCalorias/{name}/{peso}")
    public ResponseEntity<Integer> obtenerCaloriasDeUnPlato(@PathVariable String name, @PathVariable int peso){
        return new ResponseEntity<Integer>(platoService.obtenerCalorias(name,peso), HttpStatus.OK);
    }

    @GetMapping("listarIngredientes/{name}")
    public ResponseEntity<List<Ingrediente>> listarIngredientes(@PathVariable String name){
        return new ResponseEntity<>(platoService.listarIngredientes(), HttpStatus.OK);
    }

    @GetMapping("ingredienteCalorico/{name}")
    public ResponseEntity<Ingrediente> obtenerIngredienteCalorico(@PathVariable String name){
        return new ResponseEntity<>(platoService.obtenerIngredienteCalorico(), HttpStatus.OK);
    }

}
