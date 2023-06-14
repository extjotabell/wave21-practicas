package com.bootcamp.edadPersona.controller;

import com.bootcamp.edadPersona.services.edadPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class edadPersonaController {

    @Autowired
    edadPersonaService edadPersonaService;

    @GetMapping("/{day}/{month}/{year}")
    public int ageCalculator(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return edadPersonaService.calculateAge(day, month, year);
    }
}
