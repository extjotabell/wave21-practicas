package com.example.generico.controller;


import com.example.generico.DTO.PersonaDTO;
import com.example.generico.DTO.PersonaRiesgoDTO;
import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;
import com.example.generico.services.PersonaRiesgoService;
import com.example.generico.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

  @PostMapping("/persona")
  public ResponseEntity<Integer> persona(@RequestBody PersonaDTO p) {
    Persona persona = PersonaService.crearPersona(p);

    return new ResponseEntity<>(persona.getId(), HttpStatus.OK);
  }

  @PostMapping("/personaRiesgo")
  public ResponseEntity<Integer> riesgo(@RequestBody PersonaRiesgoDTO pr) {
    PersonaRiesgo personaRiesgo = PersonaRiesgoService.crearPersonaRiesgo(pr);

    return new ResponseEntity<>(personaRiesgo.getId(), HttpStatus.OK);
  }
}
