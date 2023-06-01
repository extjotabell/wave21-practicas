package com.bootcamp.edadPersona.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Service
public class AgeService {

    public int calcularEdad(int day, int month, int year) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        dtf.format(now);
        LocalDate birth = LocalDate.of(year, month, day);
        dtf.format(birth);
        return ((int) ChronoUnit.YEARS.between(birth, now));
    }
}
