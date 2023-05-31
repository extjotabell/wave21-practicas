package com.mercadolibre.practicasspringapis.controllers.covid19;

import com.mercadolibre.practicasspringapis.dtos.covid19.RiskPersonDTO;
import com.mercadolibre.practicasspringapis.dtos.covid19.SymptomDTO;
import com.mercadolibre.practicasspringapis.services.covid19.Covid19Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/covid19")
public class Covid19Controller {

    @Autowired
    Covid19Service covidService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom(){
        return ResponseEntity.ok(covidService.getSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findGravityOfSymptom(@PathVariable String name){
        return ResponseEntity.ok(covidService.getSymptomByName(name));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> findRiskPeople(){
        return ResponseEntity.ok(covidService.getRiskPersons());
    }
}
