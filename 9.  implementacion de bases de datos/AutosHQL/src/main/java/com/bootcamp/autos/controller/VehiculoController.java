package com.bootcamp.autos.controller;

import com.bootcamp.autos.dto.VehiculoDTO;
import com.bootcamp.autos.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
