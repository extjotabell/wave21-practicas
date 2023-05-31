package com.ejercicio.deportistas.controller;

import java.util.Scanner;

import com.ejercicio.deportistas.classes.Deporte;
import com.ejercicio.deportistas.classes.Persona;
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
    private final List<Deporte> deportes = new ArrayList<>();
    private final List<Persona> personas = new ArrayList<>();

    public Controller(){
        deportes.add(new Deporte("Futbol", 1));
        deportes.add(new Deporte("Tenis", 2));
        deportes.add(new Deporte("Ciclismo", 3));
        personas.add(new Persona("Juan", "Garcia", 15));
        personas.add(new Persona("Pedro", "Verstapen", 24));
        personas.add(new Persona("Nico", "Perez", 13));
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> listarDeportes(){
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> listaDeporte(@PathVariable String name){
        Deporte deporteEncontrado = deportes.stream().filter(deporte -> deporte.getNombre().equals(name)).findFirst().orElse(null);
        if (deporteEncontrado != null){
            return new ResponseEntity<>("El deporte " + deporteEncontrado.getNombre() + " tiene un nivel de " + deporteEncontrado.getNivel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Deporte no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> listarDeportistas(){
        Scanner scanner = new Scanner(System.in);
        List<PersonaDTO> deportistas = new ArrayList<>();
        for(Persona persona : personas){
            System.out.print(persona.getNombre() + " ¿Que deporte practicas? \n");
            String deportePractica = scanner.nextLine();
            Deporte deporteEncontrado = deportes.stream().filter(deporte -> deporte.getNombre().equals(deportePractica)).findFirst().orElse(null);
            if (deporteEncontrado != null){
                deportistas.add(new PersonaDTO(persona.getNombre(), persona.getApellido(), deportePractica));
            }else{
                System.out.println("Deporte no existe");
            }
        }
        return new ResponseEntity<>(deportistas, HttpStatus.OK);
    }
}
