package com.example_consigna.consigna;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralsController {

    private final RomanNumeralsService romanNumeralsService;

    public RomanNumeralsController(RomanNumeralsService romanNumeralsService) {
        this.romanNumeralsService = romanNumeralsService;
    }

    @GetMapping("/romannumeral/{number}")
    public String convertToRomanNumeral(@PathVariable int number) {
        return romanNumeralsService.convertToRomanNumeral(number);
    }
}
