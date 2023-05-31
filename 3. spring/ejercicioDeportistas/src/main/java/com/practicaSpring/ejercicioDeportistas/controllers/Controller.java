package com.practicaSpring.ejercicioDeportistas.controllers;

import com.practicaSpring.ejercicioDeportistas.model.Deporte;
import com.practicaSpring.ejercicioDeportistas.dto.DeporteXPersonaDTO;
import com.practicaSpring.ejercicioDeportistas.model.Persona;
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
    private final List<DeporteXPersonaDTO> deporteXPersona = new ArrayList<>();

    public Controller(){
        //Listado de Deportes
        deportes.add(new Deporte("Atletismo",1));
        deportes.add(new Deporte("Patinaje",2));
        deportes.add(new Deporte("Natacion",3));
        deportes.add(new Deporte("Fubbol",4));
        deportes.add(new Deporte("Boxeo",5));

        //Listado de Personas
        personas.add(new Persona("Manuel", "Garcia", 20));
        personas.add(new Persona("Lorna", "Cepeda", 45));
        personas.add(new Persona("Julio", "Perez", 66));

        //Lista de Deportes por Personas
        deporteXPersona.add(new DeporteXPersonaDTO("Julio", "Perez","Futbol"));
        deporteXPersona.add(new DeporteXPersonaDTO("Lorna", "Cepeda","Patinaje"));
        deporteXPersona.add(new DeporteXPersonaDTO("Manuel", "Garcia","Atletismo"));

    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> listarDeportes(){
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSports/{nombre}")
    public ResponseEntity<String> listarDeportes(@PathVariable String nombre){

        Deporte deporteAEncontrar = deportes.stream().filter(deporte -> deporte.getNombre().equals(nombre)).findFirst().orElse(null);
        if (deporteAEncontrar != null){
            return new ResponseEntity<>("El deporte: " + deporteAEncontrar.getNombre() +
                    " cuenta con un nivel de: " + deporteAEncontrar.getNivel(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("El deporte no fue encontrado!!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeporteXPersonaDTO>> listarDeportesXPersona() {
        return new ResponseEntity<>(deporteXPersona, HttpStatus.OK);
    }


}
