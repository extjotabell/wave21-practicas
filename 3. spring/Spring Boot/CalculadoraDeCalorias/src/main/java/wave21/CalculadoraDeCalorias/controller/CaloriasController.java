package wave21.CalculadoraDeCalorias.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wave21.CalculadoraDeCalorias.dto.DishDTO;
import wave21.CalculadoraDeCalorias.dto.DishResponseDTO;
import wave21.CalculadoraDeCalorias.service.DishService;

@RestController
public class CaloriasController {
    private final DishService service;

    public CaloriasController(DishService service) {
        this.service = service;
    }

    @GetMapping("{dishName}")
    public ResponseEntity<DishResponseDTO> calories(@PathVariable String dishname){
        return new ResponseEntity<>(service.calcularCaloriasTotales(dishname), HttpStatus.OK);
    }

}
