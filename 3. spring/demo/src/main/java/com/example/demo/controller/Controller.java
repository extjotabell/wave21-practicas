package com.example.demo.controller;

import com.example.demo.services.Convertidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    Convertidor convertidor;

    @GetMapping("/{numero}")
    public String convertirRomano(@PathVariable String numero){
        return "El número romano es: " + convertidor.conversorANumeroRomano(numero);
    }
}
