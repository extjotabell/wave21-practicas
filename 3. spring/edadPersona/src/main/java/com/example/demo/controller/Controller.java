package com.example.demo.controller;

import com.example.demo.services.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    AgeService ageService;

    @GetMapping("/{day}/{month}/{year}")
    public int calcularAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return ageService.calcularEdad(day, month, year);
    }
}