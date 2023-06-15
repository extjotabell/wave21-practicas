package com.example.generico.controller;


import com.example.generico.DTO.*;
import com.example.generico.DTO.response.PersonaIdDTO;
import com.example.generico.DTO.response.PersonaRiesgoIdDTO;
import com.example.generico.DTO.response.PersonaRiesgoResponseDTO;
import com.example.generico.services.PersonaRiesgoService;
import com.example.generico.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController {

  @Autowired
  PersonaService personaService;

  @Autowired
  PersonaRiesgoService personaRiesgoService;

  @PostMapping("/persona")
  public ResponseEntity<PersonaIdDTO> persona(@RequestBody PersonaDTO p) {
    PersonaIdDTO persona = personaService.crearPersona(p);

    return new ResponseEntity<>(persona, HttpStatus.OK);
  }

  @GetMapping("/personaRiesgo")
  public ResponseEntity<List<PersonaRiesgoResponseDTO>> riesgo(@RequestParam Optional<String> sintoma) {

    List<PersonaRiesgoResponseDTO> personas = sintoma
      .map(personaRiesgoService::buscarPersonaRiesgo)
      .orElseGet(personaRiesgoService::buscarPersonaRiesgo);

    return new ResponseEntity<>(personas, HttpStatus.OK);
  }

  @PostMapping("/personaRiesgo")
  public ResponseEntity<PersonaRiesgoIdDTO> riesgo(@RequestBody PersonaRiesgoDTO pr) {
    PersonaRiesgoIdDTO personaRiesgo = personaRiesgoService.crearPersonaRiesgo(pr);

    return new ResponseEntity<>(personaRiesgo, HttpStatus.OK);
  }
}
