package com.bootcamp.sistemaSalud.controller;

import com.bootcamp.sistemaSalud.dto.PersonaRiesgoDTO;
import com.bootcamp.sistemaSalud.servicio.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
PersonaService servicio = new PersonaService();
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaRiesgoDTO>> obtenerPacienteRiesgo() {

        /// Agregar logica por si no se encuentran pacientes de riesgo
        return new ResponseEntity<List<PersonaRiesgoDTO>>(servicio.obtenerPacientesRiesgo(),HttpStatus.OK);
    }
}
