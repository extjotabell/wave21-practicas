package com.example.demo.controller;

import com.example.demo.dto.Deporte;
import com.example.demo.dto.DeportesPorPersona;
import com.example.demo.dto.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SportController {

    private final List<Deporte> deporteList = new ArrayList<Deporte>();
    private final List<Persona> personaList = new ArrayList<Persona>();
    private final List<DeportesPorPersona> deportesPorPersonaList = new ArrayList<DeportesPorPersona>();

    public SportController() {
        personaList.add(new Persona("Juan", "Pérez", 25));
        personaList.add(new Persona("María", "Gómez", 30));
        personaList.add(new Persona("Carlos", "López", 20));
        personaList.add(new Persona("Ana", "Rodríguez", 28));

        deporteList.add(new Deporte("Fútbol", 3));
        deporteList.add(new Deporte("Tenis", 2));
        deporteList.add(new Deporte("Natación", 1));
        deporteList.add(new Deporte("Baloncesto", 3));

        deportesPorPersonaList.add(new DeportesPorPersona("Juan", "Pérez", "Fútbol"));
        deportesPorPersonaList.add(new DeportesPorPersona("María", "Gómez", "Tenis"));
        deportesPorPersonaList.add(new DeportesPorPersona("Carlos", "López", "Natación"));
        deportesPorPersonaList.add(new DeportesPorPersona("Ana", "Rodríguez", "Baloncesto"));

    }
    @GetMapping("/findSports")
    public List<Deporte> findDeportes(){ //@RequestBody clase nombre
        return deporteList;
    }

    @GetMapping("/findSport/{name}")
    public Deporte findDeportesByName(@PathVariable String name){ //@RequestBody clase nombre
        return deporteList.stream().filter(deporte -> deporte.getNombre().equals(name))
                .findFirst().orElse(null);
    }

    @GetMapping("/findSportsPersons")
    public List<DeportesPorPersona> findSportsPersons(){ //@RequestBody clase nombre
        return deportesPorPersonaList;
    }


}
