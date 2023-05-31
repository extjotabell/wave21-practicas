package com.example.spring_P2_VIVO.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class CodigoMorse {

    @GetMapping("/{codigo}")
    public String convertirCodigo(@PathVariable String codigo) {
        Map<String, String> morseCodeMap = new HashMap<String, String>() {
            {
                put(".-", "A");
                put("-...", "B");
                put("-.-.", "C");
                put("-..", "D");
                put(".", "E");
                put("..-.", "F");
                put("--.", "G");
                put("....", "H");
                put("..", "I");
                put(".---", "J");
                put("-.-", "K");
                put(".-..", "L");
                put("--", "M");
                put("-.", "N");
                put("---", "O");
                put(".--.", "P");
                put("--.-", "Q");
                put(".-.", "R");
                put("...", "S");
                put("-", "T");
                put("..-", "U");
                put("...-", "V");
                put(".--", "W");
                put("-..-", "X");
                put("-.--", "Y");
                put("--..", "Z");
                put("-----", "0");
                put(".----", "1");
                put("..---", "2");
                put("...--", "3");
                put("....-", "4");
                put(".....", "5");
                put("-....", "6");
                put("--...", "7");
                put("---..", "8");
                put("----.", "9");
                put(".-.-.-", ".");
                put("--..--", ",");
                put("..--..", "?");
                put(".----.", "'");
                put("-.-.--", "!");
            }
        };

        String[] palabrasSplitted = codigo.split("   ");

        String codigoConvertido = "";

        for (int i=0; i<palabrasSplitted.length; i++){

            //System.out.println(palabrasSplitted[i]);

            String[] letrasSplitted = palabrasSplitted[i].split(" ");

            for (int j=0; j< letrasSplitted.length; j++) {
                //System.out.println(letrasSplitted[j]);

                if (morseCodeMap.get(letrasSplitted[j]) != null) {
                    codigoConvertido += morseCodeMap.get(letrasSplitted[j]);
                } else {
                    codigoConvertido += " ";
                }
            }

        }



        return codigoConvertido;

    }
}
