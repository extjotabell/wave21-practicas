package com.bootcamp.autos.controller;

import com.bootcamp.autos.dto.SiniestroDTO;
import com.bootcamp.autos.service.ISiniestroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {

private ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<SiniestroDTO> addSiniestro(@PathVariable Long id, @RequestBody SiniestroDTO siniestroDTO){
        return ResponseEntity.ok(siniestroService.saveSiniestro(id,siniestroDTO));
    }

    @DeleteMapping("/delete/{idVehiculo}/{idSiniestro}")
    public ResponseEntity<SiniestroDTO> deleteSiniestro(@PathVariable Long idVehiculo, @PathVariable  Long idSiniestro){
        return ResponseEntity.ok(siniestroService.deleteSiniestro(idVehiculo,idSiniestro));
    }
}
