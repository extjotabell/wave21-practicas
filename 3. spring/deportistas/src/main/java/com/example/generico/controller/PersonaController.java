package com.example.generico.controller;

import com.example.generico.DTO.PersonaDTO;
import com.example.generico.services.PersonaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
  @GetMapping("/personas")
  public ResponseEntity<List<PersonaDTO>> buscarPersonas() {
    List<PersonaDTO> personas = PersonaServices.buscarPersonas();

    return new ResponseEntity<>(personas, HttpStatus.OK);
  }
  @GetMapping("/persona/{id}")
  public ResponseEntity<PersonaDTO> buscarPersona(@PathVariable Integer id) {
    // TODO validar si ese id no existe
    PersonaDTO persona = PersonaServices.buscarPersonaPorId(id);

    return new ResponseEntity<>(persona, HttpStatus.OK);
  }
}
