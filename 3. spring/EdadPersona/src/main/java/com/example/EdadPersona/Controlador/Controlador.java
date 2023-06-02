package com.example.EdadPersona.Controlador;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/edad")
public class Controlador {
    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio)
    {
        LocalDate fechaActual = LocalDate.now();
        int edad = 0;

        edad = (fechaActual.getYear() - anio);
        if(fechaActual.getMonthValue() < mes){
            edad--;
        }
        if(fechaActual.getMonthValue() == mes && fechaActual.getDayOfMonth() < dia){
            edad--;
        }

        return edad;
    }
}
