package com.example.ejercicioCovid19.Controller;


import com.example.ejercicioCovid19.Clases.PersonaDTO;
import com.example.ejercicioCovid19.Clases.ResponseDto;
import com.example.ejercicioCovid19.Clases.Sintoma;
import com.example.ejercicioCovid19.Services.PersonaService;
import com.example.ejercicioCovid19.Services.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSymptom")
public class Controller {

    @Autowired
    SintomaService sintomaService;

    @Autowired
    PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Sintoma>> findSymptom(){
        return new ResponseEntity<>(sintomaService.findSymptom(), HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String name) {
        if (sintomaService.findSymptomByName(name) == null) {
            return new ResponseEntity<>("No se encuentra registrado el sintoma", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(sintomaService.findSymptomByName(name).getNivel_de_gravedad(), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/findRiskPerson")
    public ResponseEntity<List<ResponseDto>>  findRiskPerson(){
        return new ResponseEntity<>(personaService.findRiskPerson(), HttpStatus.OK);
    }
}
