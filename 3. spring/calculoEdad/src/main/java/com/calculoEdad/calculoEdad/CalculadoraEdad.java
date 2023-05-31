package com.calculoEdad.calculoEdad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculadoraEdad {


    @GetMapping("/{day}/{month}/{year}")
    public String calculadoraEdad(@PathVariable int day,
                                @PathVariable int month,
                                @PathVariable int year) {

        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();

        Period age = Period.between(birthdate, now);
        int years = age.getYears();
        int months = age.getMonths();

        return "EDAD ---- " + years + "con " + months + "meses ";

    }
}
