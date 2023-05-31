package com.ejcovid.ejcovid.controller;


import com.ejcovid.ejcovid.services.Entidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Entidades entidades;

    // PathVariable se agrega para usar variables en la url
    @GetMapping("/findSymptom")
    public String viewSymp(){
        return entidades.searchSymp();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> viewName(@PathVariable String name) {
        return new ResponseEntity<>(entidades.searchSympName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public String viewRiskPerson(){
        return entidades.searchPersonaRiesgo();
    }



}