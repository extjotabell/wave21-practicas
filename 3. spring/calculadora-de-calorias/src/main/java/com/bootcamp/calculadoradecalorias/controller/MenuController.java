package com.bootcamp.calculadoradecalorias.controller;

import com.bootcamp.calculadoradecalorias.dto.DishRequestDTO;
import com.bootcamp.calculadoradecalorias.dto.MenuDTO;
import com.bootcamp.calculadoradecalorias.dto.MenuMultiResponseDTO;
import com.bootcamp.calculadoradecalorias.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    IMenuService menuService;

    @GetMapping("/dish")
    public ResponseEntity<MenuDTO> getNutritionalFacts(@RequestParam String name, @RequestParam String weight){
        return new ResponseEntity<>(menuService.getNutritionalFacts(name, weight), HttpStatus.OK);
    }

    //BONUS
    @GetMapping("/dishes")
    public ResponseEntity<List<MenuMultiResponseDTO>> getNutritionalFactsMulti(@RequestBody DishRequestDTO[] ingredients){
        return new ResponseEntity<>(menuService.getNutritionalFactsMulti(Arrays.stream(ingredients).toList()), HttpStatus.OK);
    }
}
