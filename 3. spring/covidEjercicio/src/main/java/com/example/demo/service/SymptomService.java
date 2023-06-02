package com.example.demo.service;

import com.example.demo.dto.response.SymptomResponseDTO;
import com.example.demo.dto.response.SymptomSeverityDTO;
import com.example.demo.model.Symptom;
import com.example.demo.repository.SymptomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService {
    SymptomRepository repository;

    public SymptomService(SymptomRepository repository) {
        this.repository = repository;
    }

    public List<SymptomResponseDTO> listSymptoms() {
        List<Symptom> symptoms = repository.getSymptoms();
        List<SymptomResponseDTO> symptomsDTO = symptoms.stream()
                .map(symptom -> {
                    SymptomResponseDTO symptomDTO = new SymptomResponseDTO();
                    symptomDTO.setCode(symptom.getCode());
                    symptomDTO.setName(symptom.getName());
                    symptomDTO.setSeverityLevel(symptom.getSeverityLevel());
                    return symptomDTO;
                })
                .collect(Collectors.toList());
        return symptomsDTO;
    }

    public SymptomSeverityDTO getSymptom(String name) {
        Symptom symptom = repository.findByName(name);
        SymptomSeverityDTO severityDTO = new SymptomSeverityDTO();
        severityDTO.setSeverityLevel(symptom.getSeverityLevel());
        return severityDTO;
    }
    /*
    public List<PersonFullNameDTO> getRiskPeople(){
        return repository.findAllPersonRisk().stream().map(person -> {
        var personDTO = new personFullNameDTO();
        personDTO.setName();
        return personDTO;
        }).toList();
    }
     */

}
