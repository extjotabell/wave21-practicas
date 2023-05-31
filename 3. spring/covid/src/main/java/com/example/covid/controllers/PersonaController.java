package com.example.covid.controllers;

import com.example.covid.entidades.Persona;
import com.example.covid.entidades.Sintoma;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    List<Persona> personas = new ArrayList<Persona>();
    List<Sintoma> sintomas = new ArrayList<Sintoma>();

    public PersonaController(){

        System.out.println("Creando personas..");

        Persona p1 = new Persona(UUID.randomUUID(), "Juan", "Perez", 20);
        Persona p2 = new Persona(UUID.randomUUID(), "Maria", "Gomez", 30);
        Persona p3 = new Persona(UUID.randomUUID(), "Pedro", "Gonzalez", 15);
        Persona p4 = new Persona(UUID.randomUUID(), "Jose", "Rodriguez", 35);

        Sintoma s1 = new Sintoma(UUID.randomUUID(), "Fiebre", 1);
        Sintoma s2 = new Sintoma(UUID.randomUUID(), "Tos", 2);
        Sintoma s3 = new Sintoma(UUID.randomUUID(), "Dolor de cabeza", 3);

        System.out.println("Personas creadas..");
    }
    @GetMapping("/findSymptom")
    public String findSymptom(){
        return "Hola mundo";
    }


}
