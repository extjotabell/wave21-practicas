package com.example.deportistas.controller;

import com.example.deportistas.DTO.PersonaDeporteDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {
    @Autowired
    DeporteService deporteService;

    @GetMapping("/findSports")
    public List<Deporte> verTodos() {
        return ResponseEntity.ok(deporteService.mostrarDeportes()).getBody();
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> verNivelDeporte(@PathVariable String name){
        return ResponseEntity.ok(deporteService.verNivelDeporte(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> verDeportesPersona(){
        return ResponseEntity.ok(deporteService.personaDeporte());
    }

}
