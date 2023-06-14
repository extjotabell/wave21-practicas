package com.bootcamp.edadPersona.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class edadPersonaService {

    public int calculateAge(int day, int month, int year) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate actualDate = LocalDate.now();
        dateFormatter.format(actualDate);

        LocalDate birthDate = LocalDate.of(year, month, day);
        dateFormatter.format(birthDate);

        return ((int) ChronoUnit.YEARS.between(birthDate, actualDate));
    }
}
