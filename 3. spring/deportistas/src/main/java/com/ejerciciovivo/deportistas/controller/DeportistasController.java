package com.ejerciciovivo.deportistas.controller;

import com.ejerciciovivo.deportistas.dto.DeportistaDto;
import com.ejerciciovivo.deportistas.model.Deporte;
import com.ejerciciovivo.deportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeportistasController {
    private ArrayList<Deporte> deportes = new ArrayList<>();
    private ArrayList<Persona> personas = new ArrayList<>();

    public DeportistasController(){
        Deporte tenis = new Deporte("tenis", "medio");
        Deporte futbol = new Deporte("futbol", "alto");
        deportes.add(tenis);
        deportes.add(futbol);

        personas.add(new Persona("Juan", "Perez", 23));
        personas.add(new Persona("Pedro", "Perez", 23, tenis));
        personas.add(new Persona("Pepe", "Perez", 28, futbol));
    }

    @GetMapping("/findSports")
    public ResponseEntity<List> getDeportes(){
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<String> getDeporte(@PathVariable String nombre){
        for (Deporte deporte: deportes) {
            if(deporte.getNombre().equalsIgnoreCase(nombre)){
                return new ResponseEntity<>(deporte.getNivel(),HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("El deporte " + nombre + " no se encuentra en la lista", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<String> getSportPersons(){
        List<DeportistaDto> personasDeportistas = personas.stream().filter(persona -> persona.getDeporte() != null )
                .map(persona -> new DeportistaDto(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()))
                .collect(Collectors.toList());
        return new ResponseEntity(personasDeportistas, HttpStatus.OK);
    }
}
