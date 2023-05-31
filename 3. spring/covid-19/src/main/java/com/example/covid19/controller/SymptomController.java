package com.example.covid19.controller;

import com.example.covid19.DTO.PersonaRiskDTO;
import com.example.covid19.model.Symptom;
import com.example.covid19.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @GetMapping("/findSymptom")
    public List<Symptom> getAllSymptoms() {
        return symptomService.getAllSymptoms();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Symptom> getSymptomByName(@PathVariable String name) {
        Symptom symptom = symptomService.getSymptomByName(name);
        if (symptom == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(symptom);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaRiskDTO>> getRiskPerson() {
        return ResponseEntity.ok(symptomService.getPersonasRiesgo());
    }
}
