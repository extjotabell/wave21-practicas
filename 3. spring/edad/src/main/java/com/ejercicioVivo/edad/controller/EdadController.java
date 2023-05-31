package com.ejercicioVivo.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;



@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public String morseAtexto (@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        String anios = "";
        try {
            LocalDate nacimiento = LocalDate.of(anio, mes, dia);
            LocalDate hoy = LocalDate.now();
            int edad = Period.between(nacimiento, hoy).getYears();
            if( edad >= 0){
                anios = String.valueOf(edad);
            }else{
                anios = "Esta persona aún no nació";
            }
        } catch (DateTimeException e){
            anios = "La fecha ingresada no existe";
        }
        return anios;

    }
}
