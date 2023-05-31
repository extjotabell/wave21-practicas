package com.bootcamp.ejercicioCovid.controllers;

import com.bootcamp.ejercicioCovid.dtos.RiskPersonDTO;
import com.bootcamp.ejercicioCovid.dtos.SymptomDTO;
import com.bootcamp.ejercicioCovid.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/covid19")
public class CovidController {

    @Autowired
    CovidService covidService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom() {
        return ResponseEntity.ok(covidService.getSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findGravityOfSymptom(@PathVariable String name) {
        return ResponseEntity.ok(covidService.getSymptomByName(name));
    }

    @GetMapping("/findRiskPersons")
    public ResponseEntity<List<RiskPersonDTO>> findRiskPersons() {
        return ResponseEntity.ok(covidService.getRiskPersons());
    }
}