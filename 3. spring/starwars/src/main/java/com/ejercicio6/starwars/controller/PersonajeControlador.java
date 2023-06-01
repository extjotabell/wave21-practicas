package com.ejercicio6.starwars.controller;

import com.ejercicio6.starwars.service.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/personajes")
public class PersonajeControlador {
    @Autowired
    private PersonajeServicio personajeServicio;

    @GetMapping("/{nombre}")
    public ResponseEntity<?> filterByName(@PathVariable(value = "nombre") String nombre){
        return ResponseEntity.ok(personajeServicio.getPersonaje(nombre));
    }

}
