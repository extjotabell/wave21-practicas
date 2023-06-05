package com.example.numeros_romanos.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class test {

    @GetMapping("/test/{prueba}")
    public String test(@PathVariable int prueba){
        return "Test " + prueba;
    }
}
