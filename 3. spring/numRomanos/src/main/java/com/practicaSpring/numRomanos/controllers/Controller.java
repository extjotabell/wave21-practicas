package com.practicaSpring.numRomanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/{numero}")
    public String numeroRomano(@PathVariable int numero){
        int[] numerosDecimales = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] numeroRomanos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder numeroRomano = new StringBuilder();

        for (int i = 0; i < numerosDecimales.length; i++) {
            while(numero >= numerosDecimales[i]){
                numeroRomano.append(numeroRomanos[i]);
                numero -= numerosDecimales[i];
            }
        }

        return numeroRomano.toString();
    }

}
