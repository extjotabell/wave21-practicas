package com.example.demo.controller;

import com.example.demo.dto.response.SymptomResponseDTO;
import com.example.demo.dto.response.SymptomSeverityDTO;
import com.example.demo.model.Symptom;
import com.example.demo.service.SymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

// El controller solo debe conocer DTOs.
@RestController
public class SymptomController {

    // opcion 2: @Autowired
    // @Autowired
    SymptomService service;

    // injección de dependencia a través del constructor.
    public SymptomController(SymptomService service){ // inversion de control, es la librería o framework que se encargue de esto.
        this.service = service;
    }

    @GetMapping("/findSymptoms")
    public ResponseEntity<List<SymptomResponseDTO>> listOfSymptoms(){
        return new ResponseEntity<>(service.listSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomSeverityDTO> symptomSeverity(@PathVariable String name){

        if (!Objects.isNull(service.getSymptom(name))){
            return new ResponseEntity<>(service.getSymptom(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.getSymptom(name), HttpStatus.OK);
    }

    /*


    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PeopleDTO>> findRiskPersons(){
        PeopleDTO p = (PeopleDTO) peopledtos.stream().filter(peopleDTO -> peopleDTO.getAge() >= 60 && peopleDTO.getCodeSymptom().size() > 0);
        return new ResponseEntity<>(peopledtos, HttpStatus.OK);
    }
     */
}
