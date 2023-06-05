package com.example.dto_response_entity_VIVO_p_2.controller;

import com.example.dto_response_entity_VIVO_p_2.entity.Deporte;
import com.example.dto_response_entity_VIVO_p_2.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeporteController {
    @Autowired
    IDeporteService service;
    @GetMapping("findSports")
    public ResponseEntity<?> getSport() {
        return new ResponseEntity<>(service.getSport(), HttpStatus.OK);
    };
    @GetMapping("findSport/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
    }
    @GetMapping("findSportsPersons")
    public ResponseEntity<?> getSportsByPerson() {
        return new ResponseEntity<>(service.getSportsByPerson(), HttpStatus.OK);
    }
}
