package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class RomanosController {
    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable int numero){
        String numeroRomano = "";
        int numeroAux = numero;
        int auxCantidadLetras = 0;
        Map<String, Integer> valores = new LinkedHashMap<>();
        valores.put("M", 1000);
        valores.put("CM", 900);
        valores.put("D", 500);
        valores.put("CD", 400);
        valores.put("C", 100);
        valores.put("XC", 90);
        valores.put("L", 50);
        valores.put("XL", 40);
        valores.put("X", 10);
        valores.put("IX", 9);
        valores.put("V", 5);
        valores.put("IV", 4);
        valores.put("I", 1);
        // Imprimir el mapa
        for (Map.Entry<String, Integer> entry : valores.entrySet()) {
            auxCantidadLetras = numeroAux / entry.getValue();
            numeroAux = numeroAux % entry.getValue();

            for (int i = 0; i < auxCantidadLetras; i++)
                numeroRomano += (entry.getKey());
        }



        return numeroRomano;
    }
}
