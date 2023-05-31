package com.deportistas.deportistas.Controllers;

import com.deportistas.deportistas.DTOS.DeportistaDTO;
import com.deportistas.deportistas.DTOS.Persona;
import com.deportistas.deportistas.Services.PersonaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    private PersonaServicio servicio;

    public PersonaController(){
        this.servicio = new PersonaServicio();
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> obtenerPersonas(){
        return new ResponseEntity<>(servicio.obtenerPersonas(), HttpStatus.OK);
    }

    @GetMapping("/persona/{nombre}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable String nombre){
        return new ResponseEntity<>(servicio.obtenerPorNombre(nombre), HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarPersona(@RequestBody Persona persona) {
        servicio.agregarPersona(persona);
        return new ResponseEntity<>("Persona agregada con exito", HttpStatus.OK);
    }



}
