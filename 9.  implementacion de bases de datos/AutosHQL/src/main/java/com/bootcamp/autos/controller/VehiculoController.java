package com.bootcamp.autos.controller;

import com.bootcamp.autos.dto.ListPatenteYModeloDTO;
import com.bootcamp.autos.dto.ListVehiculoDTO;
import com.bootcamp.autos.dto.ListVehiculoPatenteDTO;
import com.bootcamp.autos.dto.VehiculoDTO;
import com.bootcamp.autos.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    private IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/create")
    public ResponseEntity<VehiculoDTO> saveCar(@RequestBody VehiculoDTO dto){
        return ResponseEntity.ok(vehiculoService.saveCar(dto));
    }

    @GetMapping("/getcar/{id}")
    public ResponseEntity<VehiculoDTO> getCarByID(@PathVariable Long id){
        return ResponseEntity.ok(vehiculoService.findById(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<ListVehiculoDTO> getAllCar(){
        return ResponseEntity.ok(vehiculoService.findAll());
    }

    @GetMapping("/getpatente")
    public ResponseEntity<ListVehiculoPatenteDTO> getAllPatente(){
        return ResponseEntity.ok(vehiculoService.findByPatente());
    }

    @GetMapping("/getpatenteymodelo")
    public ResponseEntity<ListPatenteYModeloDTO> getPatenteYModeloOrdenadoPorAnio(){
        return ResponseEntity.ok(vehiculoService.findPatenteAndMarceOrderByAnioFabricacion());
    }
    @GetMapping("/withperdidaeconomia")
    public ResponseEntity<?> getWithPerdidaEconomica(){

        return ResponseEntity.ok(vehiculoService.findCarWithElevateEconomicLost());
    }
}
