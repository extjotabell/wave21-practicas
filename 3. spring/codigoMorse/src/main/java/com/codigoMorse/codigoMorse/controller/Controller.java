package com.codigoMorse.codigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/{code}")
    public String morseCode(@PathVariable String code) {

        Map<String, String> moseCode = new HashMap<>();

        moseCode.put(".-", "A");
        moseCode.put("-...", "B");
        moseCode.put("-.-.", "C");
        moseCode.put("-..", "D");
        moseCode.put(".", "E");
        moseCode.put("..-.", "F");
        moseCode.put("--.", "G");
        moseCode.put("....", "H");
        moseCode.put("..", "I");
        moseCode.put(".---", "J");
        moseCode.put("-.-", "K");
        moseCode.put(".-..", "L");
        moseCode.put("--", "M");
        moseCode.put("-.", "N");
        moseCode.put("---", "O");
        moseCode.put(".--.", "P");
        moseCode.put("--.-", "Q");
        moseCode.put(".-.", "R");
        moseCode.put("...", "S");
        moseCode.put("-", "T");
        moseCode.put("..-", "U");
        moseCode.put("...-", "V");
        moseCode.put(".--", "W");
        moseCode.put("-..-", "X");
        moseCode.put("-.--", "Y");
        moseCode.put("--..", "Z");
        moseCode.put("-----", "0");
        moseCode.put(".----", "1");
        moseCode.put("..---", "2");
        moseCode.put("...--", "3");
        moseCode.put("....-", "4");
        moseCode.put(".....", "5");
        moseCode.put("-....", "6");
        moseCode.put("--...", "7");
        moseCode.put("---..", "8");
        moseCode.put("----.", "9");
        moseCode.put(".-.-.-", ".");
        moseCode.put("--..--", ",");
        moseCode.put("..--..", "?");
        moseCode.put("-.-.--", "!");

        String[] palabras = code.split("\\s{3}");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            String[] letras = palabra.split("\\s");

            for (String letra : letras) {
                String aux = moseCode.get(letra);
                System.out.println(aux);
                if (aux != null) {
                    resultado.append(aux);
                } else {
                    resultado.append("#");
                }
            }
            resultado.append(" ");
        }

        return resultado.toString().trim();

    }

}
