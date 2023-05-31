package com.bootcamp.ejercicioDeportistas.controllers;

import com.bootcamp.ejercicioDeportistas.dtos.DeporteDTO;
import com.bootcamp.ejercicioDeportistas.dtos.PersonaDTO;
import com.bootcamp.ejercicioDeportistas.services.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    @Autowired
    DeportistaService deportistaService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        return ResponseEntity.ok(deportistaService.findSports());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String name){
        DeporteDTO dto = deportistaService.findSport(name);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }


    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findSportsPersons(){
        return ResponseEntity.ok(deportistaService.findSportsPersons());
    }
}
