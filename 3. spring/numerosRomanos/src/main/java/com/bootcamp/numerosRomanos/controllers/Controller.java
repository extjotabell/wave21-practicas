package com.bootcamp.numerosRomanos.controllers;

import com.bootcamp.numerosRomanos.services.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Converter converter;

    @GetMapping("/{number}")
    public String toRomanConverter(@PathVariable String number) {
        return "El número romano es: " + converter.decimalToRomanConverter(number);
    }
}
