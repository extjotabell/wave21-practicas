package com.codigomorse.codigomorse.controller;


import com.codigomorse.codigomorse.services.codigoMorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    codigoMorse morse;

    // PathVariable se agrega para usar variables en la url
    @GetMapping("/{palabra}")
    public String codigoMorse(@PathVariable String palabra){
        palabra = palabra.replaceAll("\\s{3}", " p ");
        return "El texto convertido es: " + morse.conversorAMorse(palabra);
    }
}
