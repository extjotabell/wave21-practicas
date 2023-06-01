package com.example.generico.controller;

import com.example.generico.DTO.SintomaDTO;
import com.example.generico.DTO.response.SintomaResponseDTO;
import com.example.generico.entity.Sintoma;
import com.example.generico.services.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SintomaController {
  @GetMapping("/sintoma/{name}")
  public ResponseEntity<SintomaResponseDTO> sintoma(@PathVariable String name) {

    SintomaResponseDTO sintoma = SintomaService.buscarSintoma(name);

    return new ResponseEntity<>(sintoma, HttpStatus.OK);
  }

  @GetMapping("/sintoma")
  public ResponseEntity<List<SintomaResponseDTO>> sintomas(@RequestBody SintomaDTO s) {
    List<SintomaResponseDTO> sintomas = SintomaService.buscarSintomas()
      .stream()
      .map(SintomaResponseDTO::new)
      .toList();

    return new ResponseEntity<>(sintomas, HttpStatus.OK);
  }

  @PostMapping("/sintoma")
  public ResponseEntity<Integer> crearSintoma(@RequestBody SintomaDTO s) {
    Sintoma sintoma = SintomaService.crearSintoma(s);

    return new ResponseEntity<>(sintoma.getId(), HttpStatus.OK);
  }
}
