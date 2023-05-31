package com.ejercicio3.edaddeunapersona.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class EdadControlador {
    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<?> edad(@PathVariable(value = "dia") String dia,
                                  @PathVariable(value = "mes") String mes,
                                  @PathVariable(value = "anio") String anio) throws ParseException {
        return ResponseEntity.ok(parseDate(dia,mes,anio));
    }

    private Integer parseDate(String dia, String mes, String anio) throws ParseException {
        SimpleDateFormat dateTimeFormatter= new SimpleDateFormat("dd/MM/yyyy");
        LocalDate fechaNac= dateTimeFormatter.parse(dia+"/"+mes+"/"+anio).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual= LocalDate.now();
        if(fechaNac.getDayOfYear()<=fechaActual.getDayOfYear())
            return Integer.valueOf(fechaActual.getYear())-Integer.valueOf(anio);
        return Integer.valueOf(fechaActual.getYear())-Integer.valueOf(anio)-1;
    }
}
