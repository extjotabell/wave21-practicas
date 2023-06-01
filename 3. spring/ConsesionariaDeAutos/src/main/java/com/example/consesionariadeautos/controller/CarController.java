package com.example.consesionariadeautos.controller;

import com.example.consesionariadeautos.dto.request.CarRequestDTO;
import com.example.consesionariadeautos.dto.response.CarResponseDTO;
import com.example.consesionariadeautos.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class CarController {
    private CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @PostMapping()
    public ResponseEntity<CarResponseDTO> addCar(@RequestBody CarRequestDTO car){
        CarResponseDTO response = carService.addCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<List<CarResponseDTO>> getCars(){
        List<CarResponseDTO> cars = carService.getCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("dates")
    public ResponseEntity<List<CarResponseDTO>> getCarsByDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        List<CarResponseDTO> cars = carService.getCarsByDate(since, to);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("prices")
    public ResponseEntity<List<CarResponseDTO>> getCarsByPrice(@RequestParam String since, @RequestParam String to){
        List<CarResponseDTO> cars = carService.getCarsByPrice(since, to);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("{id}")
    public ResponseEntity<CarResponseDTO> getCarById(@PathVariable Integer id){
        CarResponseDTO car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }
}
