package com.ejercicioSincronico.EdadDeUnaPersona.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class EdadPersonaController {

    @GetMapping("{dia}/{mes}/{anio}")
    public int calcularEdadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio ){
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate diaDeHoy = LocalDate.now();
        Period diferenciaFechas = Period.between(fechaNacimiento, diaDeHoy);

        return diferenciaFechas.getYears();
    }

}
