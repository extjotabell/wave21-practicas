package com.mercadolibre.dh.service;

import com.mercadolibre.dh.dto.response.PersonFullNameDTO;
import com.mercadolibre.dh.dto.response.SymptomResponseDTO;
import com.mercadolibre.dh.dto.response.SymptomSeverityDTO;
import com.mercadolibre.dh.model.Person;
import com.mercadolibre.dh.model.Symptom;
import com.mercadolibre.dh.repository.SymptomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService {

    SymptomRepository repository;

    public SymptomService(SymptomRepository repository) {
        this.repository = repository;
    }

    public List<SymptomResponseDTO> listSymptoms(){
        // entidades
        List<Symptom> symptoms = repository.getSymptoms();
        // conversion a lista de dto
        List<SymptomResponseDTO> symptomsDTO = symptoms
                .stream()
                .map(symptom -> {
                    var symptomDTO = new SymptomResponseDTO();
                    symptomDTO.setCode(symptom.getCode());
                    symptomDTO.setName(symptom.getName());
                    symptomDTO.setSeverityLevel(symptom.getSeverityLevel());
                    return symptomDTO;
                })
                .toList();

        return symptomsDTO;
    }

    public SymptomSeverityDTO getSymptom(String name){
        // entidad
        Symptom symptom = repository.findByName(name);
        // conversion a dto
        SymptomSeverityDTO severityDTO = new SymptomSeverityDTO();
        severityDTO.setSeverityLevel(symptom.getSeverityLevel());

        return severityDTO;
    }

    public List<PersonFullNameDTO> getRiskPeople(){
        return repository.findAllPersonRisk()
                .stream()
                .map(person -> {
                    var personDTO = new PersonFullNameDTO();
                    personDTO.setName(person.getName());
                    personDTO.setLastName(person.getLastName());
                    return personDTO;
                })
                .toList();
    }

}
