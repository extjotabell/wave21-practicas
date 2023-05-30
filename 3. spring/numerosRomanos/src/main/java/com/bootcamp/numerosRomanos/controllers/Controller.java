package com.bootcamp.numerosRomanos.controllers;

import com.bootcamp.numerosRomanos.services.Convertidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Convertidor convertidor;

    // PathVariable se agrega para usar variables en la url
    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable String numero){
        return "El numero romano es: " + convertidor.conversorANumeroRomano(numero);
    }

}
