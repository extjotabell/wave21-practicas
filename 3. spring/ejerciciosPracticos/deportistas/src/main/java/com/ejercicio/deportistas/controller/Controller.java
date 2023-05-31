package com.ejercicio.deportistas.controller;


import com.ejercicio.deportistas.dto.DeporteDTO;
import com.ejercicio.deportistas.dto.PersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private final List<DeporteDTO> deportes = new ArrayList<>();
    private final List<PersonaDTO> deportistas = new ArrayList<>();

    public Controller(){
        deportes.add(new DeporteDTO("Futbol", 1));
        deportes.add(new DeporteDTO("Tenis", 2));
        deportes.add(new DeporteDTO("Ciclismo", 3));
        deportistas.add(new PersonaDTO("Juan", "Garcia", 15, deportes.get(0)));
        deportistas.add(new PersonaDTO("Pedro", "Verstapen", 24, deportes.get(1)));
        deportistas.add(new PersonaDTO("Nico", "Perez", 13, deportes.get(2)));
    }

    @GetMapping("/findSports")
    public List<DeporteDTO> listarDeportes(){
        return deportes;
    }

    @GetMapping("/findSports/{name}")
    ResponseEntity<String> listaDeporte(@PathVariable String name){
        DeporteDTO deporteEncontrado = deportes.stream().filter(deporteDTO -> deporteDTO.getNombre().equals(name)).findFirst().orElse(null);
        if (deporteEncontrado != null){
            return new ResponseEntity<>("El deporte " + deporteEncontrado.getNombre() + " tiene un nivel de " + deporteEncontrado.getNivel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Deporte no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public List<PersonaDTO> listarDeportistas(){
        return deportistas;
    }
}
