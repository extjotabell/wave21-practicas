package com.example.EdadDeUnaPersona.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class EdadDeUnaPersonaController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(dia+"/"+mes+"/"+anio, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        return periodo.getYears();
    }
}
