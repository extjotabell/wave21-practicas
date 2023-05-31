package com.example.EdadPersona.controllers;


import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/edad")
public class EdadController {

//    Peticion GET /dia/mes/anio
//    calcula y regresa la edad de una persona basado en sus datos
    @GetMapping("/{day}/{month}/{year}")
    public int calcularEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Crear un objeto LocalDate con la fecha de nacimiento
        LocalDate fechaNacimiento = LocalDate.of(year, month, day);

        // Calcular la diferencia entre las dos fechas en anios
        Period edad = Period.between(fechaNacimiento, fechaActual);

        // Obtener la edad en anios
        int edadEnAnios = edad.getYears();

//      Se regresa la edad en anios
        return edadEnAnios;

    }


}
