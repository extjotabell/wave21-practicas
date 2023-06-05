package com.example_dto_response_entity.dto_response_entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeController {

    @GetMapping("/{day}/{month}/{year}")
    public String calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        if ((birthDate != null) && (currentDate != null)) {
            return "The person's age is: " + Period.between(birthDate, currentDate).getYears();
        } else {
            return "Cannot calculate age. Invalid date.";
        }
    }
}
