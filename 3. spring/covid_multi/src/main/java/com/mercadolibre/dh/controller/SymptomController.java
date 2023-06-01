package com.mercadolibre.dh.controller;


import com.mercadolibre.dh.dto.response.PersonFullNameDTO;
import com.mercadolibre.dh.dto.response.SymptomResponseDTO;
import com.mercadolibre.dh.dto.response.SymptomSeverityDTO;
import com.mercadolibre.dh.model.Person;
import com.mercadolibre.dh.model.Symptom;
import com.mercadolibre.dh.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class SymptomController {

    //@Autowired
    SymptomService service;

    public SymptomController(SymptomService service) {
        this.service = service;
    }

    @GetMapping("/symptoms")
    public ResponseEntity<List<SymptomResponseDTO>> listSymptoms() {
        return new ResponseEntity<>(service.listSymptoms(), OK);
    }

   @GetMapping("/symptoms/{name}")
    public ResponseEntity<SymptomSeverityDTO> getSymptom(@PathVariable String name) {
        return new ResponseEntity<>(service.getSymptom(name), OK);
    }

    @GetMapping("/risk-people")
    public ResponseEntity<List<PersonFullNameDTO>> getRiskPeople() {
        return new ResponseEntity<>(service.getRiskPeople(), OK);
    }
}