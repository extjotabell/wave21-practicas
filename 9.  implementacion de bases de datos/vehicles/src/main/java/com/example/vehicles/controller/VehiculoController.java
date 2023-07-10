package com.example.vehicles.controller;

import com.example.vehicles.entity.Vehiculo;
import com.example.vehicles.service.VehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    private VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService){
        this.vehiculoService=vehiculoService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarVehiculo(@RequestBody Vehiculo vehiculo){
        return ResponseEntity.ok(vehiculoService.agregarVehiculo(vehiculo));
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarVehiculos(){
        return ResponseEntity.ok(vehiculoService.listarVehiculos());
    }

    @GetMapping("/listarPatentes")
    public ResponseEntity<?> filtrarPorPatente(){
        return ResponseEntity.ok(vehiculoService.listarPatentes());
    }


}
