package com.example.ejerciciodeportistasenvivo.controllers;

import com.example.ejerciciodeportistasenvivo.dtos.PersonaResponseDTO;
import com.example.ejerciciodeportistasenvivo.entities.Deporte;
import com.example.ejerciciodeportistasenvivo.entities.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class DeportistasController {

    private List<Persona> personas = new ArrayList<>();
    private List<Deporte> deportes = new ArrayList<>();

    private Map<Persona,Deporte> personasDeportes = new HashMap<>();
    public DeportistasController(){

        Persona persona1 = new Persona("Juan", "Perez", 25);
        personas.add(persona1);
        Persona persona2 = new Persona("María", "Gomez", 30);
        personas.add(persona2);
        Persona persona3 = new Persona("Pedro", "Lopez", 28);
        personas.add(persona3);
        Persona persona4 = new Persona("Laura", "Fernandez", 22);
        personas.add(persona4);
        Persona persona5 = new Persona("Carlos", "Rodriguez", 35);
        personas.add(persona5);

        Deporte deporte1 = new Deporte("Fútbol", "Profesional");
        deportes.add(deporte1);
        Deporte deporte2 = new Deporte( "Tenis", "Amateur");
        deportes.add(deporte2);
        Deporte deporte3 = new Deporte( "Basket", "Profesional");
        deportes.add(deporte3);
        Deporte deporte4 = new Deporte( "Natacion", "Amateur");
        deportes.add(deporte4);
        Deporte deporte5 = new Deporte( "Atletismo", "Profesional");
        deportes.add(deporte5);

        personasDeportes.put(persona1,deporte1);
        personasDeportes.put(persona2,deporte2);
        personasDeportes.put(persona3,deporte3);
        personasDeportes.put(persona4,deporte4);
        personasDeportes.put(persona5,deporte5);
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){

        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name){
        List<Deporte> filtrada = deportes.stream().filter(deporte -> deporte.getNombre().equalsIgnoreCase(name)).toList();
        if (filtrada.size() > 0){
            return new ResponseEntity<>(filtrada, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Deporte no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons(){
        List<PersonaResponseDTO> result = new ArrayList<>();
        personasDeportes.forEach((persona, deporte) -> {
            result.add(new PersonaResponseDTO(persona.getNombre(),persona.getApellido(),deporte.getNombre()));
        });
        if(!result.isEmpty()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Ningún objeto encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
