package com.edadpersona.edadpersona.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class CalcularEdadController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer calcularEdadPersona(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio ){
        LocalDate fechaNacimiento = LocalDate.parse((dia + "/" + mes + "/" + anio), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

}
