package com.practicaSpring.numRomanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/{decimal}")
    public String convertirARomano(@PathVariable int decimal){

        Map<Integer,String> numeros = new LinkedHashMap<Integer,String>();
        StringBuilder numeroRomano = new StringBuilder();

        numeros.put(1000,"M");
        numeros.put(900,"CM");
        numeros.put(500,"D");
        numeros.put(400,"CD");
        numeros.put(100,"C");
        numeros.put(90,"XC");
        numeros.put(50,"L");
        numeros.put(40,"XL");
        numeros.put(10,"X");
        numeros.put(9,"IX");
        numeros.put(5,"V");
        numeros.put(4,"IV");
        numeros.put(1,"I");

        for (Map.Entry<Integer, String> entry : numeros.entrySet()
        ) {
            while(decimal>= entry.getKey()) {
                numeroRomano.append(entry.getValue());
                decimal -= entry.getKey();
            }
        }
        return numeroRomano.toString();
    }

}
