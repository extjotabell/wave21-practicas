package com.example.covid.controller;

import com.example.covid.clases.PersonSymptoms;
import com.example.covid.clases.Symptom;
import com.example.covid.dto.PersonSymptomsDTO;
import com.example.covid.dto.SymptomDTO;
import com.example.covid.service.CovidService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("covid")
public class CovidController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CovidService covidService;

    @GetMapping("findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom(){
        List<Symptom> symptoms = covidService.findSymptom();

        return symptoms.isEmpty() ? ResponseEntity.badRequest().body(null) : ResponseEntity.ok(symptoms.stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptom(@PathVariable String name){
        Symptom symptom = covidService.findSymptom(name);

        return symptom == null ? ResponseEntity.badRequest().body(null) : ResponseEntity.ok(convertToDto(symptom));
    }

    @GetMapping("findRiskPerson")
    public ResponseEntity<List<PersonSymptomsDTO>> findRiskPerson(){
        List<PersonSymptoms> personSymptoms = covidService.findRiskPerson();

        return personSymptoms.isEmpty() ? ResponseEntity.badRequest().body(null) : ResponseEntity.ok(personSymptoms.stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    public SymptomDTO convertToDto(Symptom symptom){
        return modelMapper.map(symptom, SymptomDTO.class);
    }

    public PersonSymptomsDTO convertToDto(PersonSymptoms personSymptoms){
        return modelMapper.map(personSymptoms, PersonSymptomsDTO.class);
    }
}
