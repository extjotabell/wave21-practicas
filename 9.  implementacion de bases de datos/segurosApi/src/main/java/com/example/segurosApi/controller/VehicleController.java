package com.example.segurosApi.controller;

import com.example.segurosApi.dto.VehiculoDto;
import com.example.segurosApi.service.VehicleService;
import com.example.segurosApi.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    VehicleService vehicleService;
    VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<VehiculoDto>> getVehicle(){
        return new ResponseEntity<>(vehicleService.getAllVehicle(), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveVehicle(@RequestBody VehiculoDto vehiculoDto){
        return new ResponseEntity<>(vehicleService.saveVehicle(vehiculoDto),HttpStatus.OK);
    }
/*

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(cartService.deleteCart(id),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id){
        return new ResponseEntity<>(cartService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateVehicle(){
        return null;
    }

 */
}
