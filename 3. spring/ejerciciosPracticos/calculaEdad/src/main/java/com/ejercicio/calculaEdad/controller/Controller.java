package com.ejercicio.calculaEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Controller {
    @GetMapping("/{dia}/{mes}/{anio}")
    public String calculaEdad(@PathVariable int dia,
                              @PathVariable int mes,
                              @PathVariable int anio){
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Crear el objeto LocalDate para la fecha de nacimiento
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        // Calcular la edad
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return "Tienes: " + periodo.getYears() + " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " dias";
    }
}
