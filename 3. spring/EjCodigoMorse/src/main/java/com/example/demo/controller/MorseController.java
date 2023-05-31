package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {

    @GetMapping("/morseatexto/{palabra}")
    public String morseAString(@PathVariable String palabra){

        Map<String, String> codigoMorse = new HashMap<>();
        codigoMorse.put(".-", "A");
        codigoMorse.put("-...", "B");
        codigoMorse.put("-.-.", "C");
        codigoMorse.put("-..", "D");
        codigoMorse.put(".", "E");
        codigoMorse.put("..-.", "F");
        codigoMorse.put("--.", "G");
        codigoMorse.put("....", "H");
        codigoMorse.put("..", "I");
        codigoMorse.put(".---", "J");
        codigoMorse.put("-.-", "K");
        codigoMorse.put(".-..", "L");
        codigoMorse.put("--", "M");
        codigoMorse.put("-.", "N");
        codigoMorse.put("---", "O");
        codigoMorse.put(".--.", "P");
        codigoMorse.put("--.-", "Q");
        codigoMorse.put(".-.", "R");
        codigoMorse.put("...", "S");
        codigoMorse.put("-", "T");
        codigoMorse.put("..-", "U");
        codigoMorse.put("...-", "V");
        codigoMorse.put(".--", "W");
        codigoMorse.put("-..-", "X");
        codigoMorse.put("-.--", "Y");
        codigoMorse.put("--..", "Z");

        String aRetornar = "";
        //Se divide el string morse en sus palabras separadas por 3 espacion.
        String[] palabrasEnMorse = palabra.split("   ");
        for(String palabraEnMorse : palabrasEnMorse){

            //Se divide el string palabraEnMorse en sus letras separadas por un espacio.
            String[] letras = palabraEnMorse.split(" ");

            //Por cada letra de cada palabra, se busca su value correspondiente.
            for(String letraEnMorse : letras){
                String texto = codigoMorse.get(letraEnMorse);
                if(texto != null) aRetornar += texto;
            }

            aRetornar += " ";
        }
    return aRetornar;
    }
}
