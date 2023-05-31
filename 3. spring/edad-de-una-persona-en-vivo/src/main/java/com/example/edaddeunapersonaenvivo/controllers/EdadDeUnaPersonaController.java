package com.example.edaddeunapersonaenvivo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@RestController
public class EdadDeUnaPersonaController {

    @GetMapping("/calcularEdad/{day}/{month}/{year}")
    public ResponseEntity<?> findAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) throws ParseException {

        LocalDateTime birthdayLocalDateTime = LocalDateTime.of(year,month,day,0,0);
        int age = Period.between(birthdayLocalDateTime.toLocalDate(), LocalDate.now()).getYears();

        return new ResponseEntity<>(age, HttpStatus.OK);
    }
}
