package com.example.generico.controller;

import com.example.generico.DTO.DeporteDTO;
import com.example.generico.services.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeporteController {
  @GetMapping("/deporte/{nombre}")
  public ResponseEntity<DeporteDTO> buscarDeporte(@PathVariable String nombre) {
    DeporteDTO d = DeporteService.buscarDeportePorNombre(nombre);
    return new ResponseEntity<>(d, HttpStatus.OK);
  }
}
