package com.example.EdadesPorRuta.service;


import com.example.EdadesPorRuta.exception.BadRequestException;
import com.example.EdadesPorRuta.exception.DateFormatException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;



@Service

public class ServiceAge {


    public ResponseEntity<?> calculateAge(String day, String month, String year) {
        int intDay;
        int intMonth;
        int intYear;
        try {
            intDay = Integer.parseInt(day);
            intMonth = Integer.parseInt(month);
            intYear = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            throw new DateFormatException("Formato de fecha incorrecto");
        }


        if (intDay > 31 || intDay < 1) {
            throw new BadRequestException("valor del DIA incorrecto, ingresa enter 1 y 31");
        }
        if (intMonth > 12 || intMonth < 1) {
            throw new BadRequestException("valor del MES incorrecto, ingresa entre 1 y 12");
        }
        if (intYear > 2050 || intYear < 1500) {
            throw new BadRequestException("valor del AÑO incorrecto, ingresa entre 1500 y 2050");
        }

        LocalDate fechaNacimiento = null;
        LocalDate fechaActual = null;
        try {
            fechaNacimiento = LocalDate.of(intYear, intMonth, intDay);
            fechaActual = LocalDate.now();

        } catch (DateTimeException e) {
            throw new BadRequestException( "Construiste mal la fecha");

        }


        Period periodo = Period.between(fechaNacimiento, fechaActual);

        return new ResponseEntity<>(periodo.getYears(), HttpStatus.OK);

    }
}
