package com.example.vehicles.controller;

import com.example.vehicles.entity.Siniestro;
import com.example.vehicles.entity.Vehiculo;
import com.example.vehicles.service.SiniestroService;
import com.example.vehicles.service.VehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {
    private final SiniestroService siniestroService;

    public SiniestroController(SiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarSiniestro(@RequestBody Siniestro siniestro) {
        return ResponseEntity.ok(siniestroService.agregarSiniestro(siniestro));
    }

    @GetMapping("/listar/vehiculo/{id_vehiculo}")
    public ResponseEntity<?> listarSiniestros(@PathVariable("id_vehiculo") Integer id_vehiculo) {
        return ResponseEntity.ok(siniestroService.listarSiniestros(id_vehiculo));
    }
    @GetMapping("/listar/{id_siniestro}")
    public ResponseEntity<?> listarSiniestro(@PathVariable("id_siniestro") Integer id_siniestro) {
        return ResponseEntity.ok(siniestroService.listarSiniestro(id_siniestro));
    }
}