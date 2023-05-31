package com.bootcamp.diaDeLaPersona.controller;

import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController

public class DiaPersonaController {

    @GetMapping("/calcularEdad")
    public int edadPersona(@RequestParam int dia, @RequestParam int mes, @RequestParam int anio){
        LocalDate hoy = LocalDate.now();
        int edad = 0;

        edad = (hoy.getYear() -anio);
        if(hoy.getMonthValue() < mes){
            edad --;
        }
        if(hoy.getMonthValue() == mes && hoy.getDayOfMonth() < dia){
            edad --;
        }

        return edad;
    }
}
