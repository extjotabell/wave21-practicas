package com.example.segurosApi.controller;

import com.example.segurosApi.dto.VehiculoDto;
import com.example.segurosApi.dto.response.RespPatentAndBrandAndModelDto;
import com.example.segurosApi.dto.response.RespPatentsListDto;
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

    VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VehiculoDto>> getVehicle() {
        return new ResponseEntity<>(vehicleService.getAllVehicle(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveVehicle(@RequestBody VehiculoDto vehiculoDto) {
        return new ResponseEntity<>(vehicleService.saveVehicle(vehiculoDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.deleteCart(id), HttpStatus.OK);
    }

    @GetMapping("/getAllPlates")
    public ResponseEntity<RespPatentsListDto> getAllPatents() {
        return new ResponseEntity<>(vehicleService.getAllPlates(), HttpStatus.OK);
    }

    @GetMapping("/getAllPAndBAndM")
    public ResponseEntity<List<RespPatentAndBrandAndModelDto>> getAllPatentAndBrandAndModel() {
        return new ResponseEntity<>(vehicleService.getAllPatentAndBrandAndModel(), HttpStatus.OK);
    }

}
