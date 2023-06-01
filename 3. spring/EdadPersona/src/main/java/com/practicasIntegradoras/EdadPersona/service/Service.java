package com.practicasIntegradoras.EdadPersona.service;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
public class Service {

    public int calculateAge(String date){

        LocalDate dateParse = LocalDate.parse(date);
        LocalDate dateNow = LocalDate.now();
        Period period = Period.between(dateParse, dateNow);

        int edad = period.getYears();
        return edad;
    }
}
