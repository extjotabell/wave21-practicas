package com.covid19.covid19.Controladores;

import com.covid19.covid19.DTOS.Persona;
import com.covid19.covid19.Servicios.PersonaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaControlador {
    private PersonaServicio servicio;

    public PersonaControlador(){
        this.servicio = new PersonaServicio();
    }

    //Agregar una persona
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarPersona(@RequestBody Persona persona) {
        servicio.agregarPersona(persona);
        return new ResponseEntity<>("Persona agregada con exito", HttpStatus.OK);
    }

    //Obetner todas las personas
    @GetMapping("/personas")
    public ResponseEntity<ArrayList<Persona>> buscarPersonas() {
        return new ResponseEntity<>(servicio.obtenerPersonas(), HttpStatus.OK);
    }

    //Obetner las personas en el grupo de riesgo
    @GetMapping("/grupoRiesgo")
    public ResponseEntity<List<Persona>> grupoRiesgo() {
        return new ResponseEntity<>(servicio.grupoDeRiesgo(), HttpStatus.OK);
    }

    //Obetner una persona por el nombre
    @GetMapping("/buscarPersona/{nombre}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable String nombre) {
        return new ResponseEntity<>(servicio.obtenerPorNombre(nombre), HttpStatus.OK);
    }
}
