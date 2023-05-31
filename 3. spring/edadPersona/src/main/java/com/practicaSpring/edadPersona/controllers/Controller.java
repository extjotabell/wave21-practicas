package com.practicaSpring.edadPersona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/practicaEdad")
public class Controller {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){

        LocalDate fecActual = LocalDate.now();
        LocalDate fecNacimiento = LocalDate.of(anio,mes,dia);

        //Calcular la diferencia entre fechas en años
        Period edad = Period.between(fecNacimiento,fecActual);
        //Obtener edad de la persona en años
        int edadPersona = edad.getYears();

        return edadPersona;
    }


}
