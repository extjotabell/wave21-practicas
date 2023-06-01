package com.example.ejercicioCovid19.controller;


import com.example.ejercicioCovid19.dto.ResponseDTO;
import com.example.ejercicioCovid19.dto.SintomaDTO;
import com.example.ejercicioCovid19.service.PersonaService;
import com.example.ejercicioCovid19.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    SintomaService sintomaService;

    @Autowired
    PersonaService personaService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> findSymptom(){
        return new ResponseEntity<>(sintomaService.findSymptom(), HttpStatus.OK);
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String name) {
        if (sintomaService.findSymptomByName(name) == null) {
            return new ResponseEntity<>("No se encuentra registrado el sintoma", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(sintomaService.findSymptomByName(name).getNivel_de_gravedad(), HttpStatus.OK);
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<ResponseDTO>> findRiskPerson(){
        return new ResponseEntity<>(personaService.findRiskPerson(), HttpStatus.OK);
    }
}