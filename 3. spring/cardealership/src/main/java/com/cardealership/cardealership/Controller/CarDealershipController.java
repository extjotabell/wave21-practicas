package com.cardealership.cardealership.Controller;

import com.cardealership.cardealership.Dto.CarRequestDto;
import com.cardealership.cardealership.Dto.CarResponseDto;
import com.cardealership.cardealership.Service.ICarDealershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class CarDealershipController {
    private ICarDealershipService _service;

    public CarDealershipController(ICarDealershipService service){
        this._service = service;
    }

    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody CarRequestDto car){
        try {
            this._service.addCar(car);
            return new ResponseEntity<>("Carro agregado con exito", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No se pudo agregar", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getAll(){
        try {
            return new ResponseEntity<>(this._service.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/dates")
    public ResponseEntity<List<CarResponseDto>> getByDate(@RequestParam Integer since){
        try {
            return new ResponseEntity<>(this._service.getByDate(since), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarResponseDto>> getByPrice(@RequestParam Double model){
        try {
            return new ResponseEntity<>(this._service.getByPrice(model), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<CarResponseDto> getByPrice(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this._service.getById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
