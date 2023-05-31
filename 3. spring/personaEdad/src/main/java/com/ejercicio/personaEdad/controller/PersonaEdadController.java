package com.ejercicio.personaEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/{dia}/{mes}/{ano}")
public class PersonaEdadController {

    @GetMapping
    public String calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano) {

        // esto es pa tener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // recibe y creo la fecha actuaal
        LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);

        // saca la dif entre la fecha que se dio y el actual
        Period periodo = Period.between(fechaNacimiento, fechaActual);

        return periodo.getYears() + "aos";

        // ejemplo para el postman
        // http://localhost:8080/13/03/1998
    }
}

