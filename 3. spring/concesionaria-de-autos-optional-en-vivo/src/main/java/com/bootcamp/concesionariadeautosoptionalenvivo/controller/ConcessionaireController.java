package com.bootcamp.concesionariadeautosoptionalenvivo.controller;

import com.bootcamp.concesionariadeautosoptionalenvivo.dto.request.VehicleRequestDTO;
import com.bootcamp.concesionariadeautosoptionalenvivo.dto.response.VehicleResponseDTO;
import com.bootcamp.concesionariadeautosoptionalenvivo.service.IConcessionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConcessionaireController {

    @Autowired
    IConcessionaireService concessionaireService;

    @PostMapping("/v1/api/vehicles")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO){
        return new ResponseEntity<>(concessionaireService.create(vehicleRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/v1/api/vehicles")
    public ResponseEntity<List<VehicleResponseDTO>> getVehicles(){
        return new ResponseEntity<>(concessionaireService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/v1/api/vehicles/dates")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesSinceTo(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>(concessionaireService.getVehiclesSinceTo(since, to), HttpStatus.OK);
    }

    @GetMapping("/v1/api/vehicles/prices")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesPrices(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>(concessionaireService.getVehiclesPrices(since, to), HttpStatus.OK);
    }

    @GetMapping("/v1/api/vehicles/{id}")
    public ResponseEntity<VehicleResponseDTO> getVehicleById(@PathVariable String id){
        return new ResponseEntity<>(concessionaireService.getVehicleById(id), HttpStatus.OK);
    }
}
