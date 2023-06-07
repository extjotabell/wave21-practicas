package com.primerproyecto.numromanos.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Persona {
    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hola mundo";
    }
}
