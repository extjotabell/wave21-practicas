package com.ejercicio.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class Controller {
    @GetMapping("/morse/{codigo}")
    public static String traducir(@PathVariable String codigo){
        // Crear el diccionario
        Map<String, Character> morseCode = new HashMap<>();
        // Agregar el código Morse y las letras correspondientes
        morseCode.put(".-", 'A');
        morseCode.put("-...", 'B');
        morseCode.put("-.-.", 'C');
        morseCode.put("-..", 'D');
        morseCode.put(".", 'E');
        morseCode.put("..-.", 'F');
        morseCode.put("--.", 'G');
        morseCode.put("....", 'H');
        morseCode.put("..", 'I');
        morseCode.put(".---", 'J');
        morseCode.put("-.-", 'K');
        morseCode.put(".-..", 'L');
        morseCode.put("--", 'M');
        morseCode.put("-.", 'N');
        morseCode.put("---", 'O');
        morseCode.put(".--.", 'P');
        morseCode.put("--.-", 'Q');
        morseCode.put(".-.", 'R');
        morseCode.put("...", 'S');
        morseCode.put("-", 'T');
        morseCode.put("..-", 'U');
        morseCode.put("...-", 'V');
        morseCode.put(".--", 'W');
        morseCode.put("-..-", 'X');
        morseCode.put("-.--", 'Y');
        morseCode.put("--..", 'Z');
        morseCode.put(".----", '1');
        morseCode.put("..---", '2');
        morseCode.put("...--", '3');
        morseCode.put("....-", '4');
        morseCode.put(".....", '5');
        morseCode.put("-....", '6');
        morseCode.put("--...", '7');
        morseCode.put("---..", '8');
        morseCode.put("----.", '9');
        morseCode.put("-----", '0');
        morseCode.put("-.-.--", '!');
        morseCode.put("..--..", '?');
        morseCode.put(".-.-.-", '.');
        morseCode.put("--..--", ',');

        StringBuilder frase = new StringBuilder();

        String [] palabras = codigo.split("   ");
        for(String palabra: palabras){
            StringBuilder palabraTraducida = new StringBuilder();
            String[] letras = palabra.split(" ");
            for(String letra: letras){

                if (!Objects.isNull(morseCode.get(letra))){
                    palabraTraducida.append(morseCode.get(letra));
                }
                else return "Codigo no valido";
            }
            frase.append(palabraTraducida+" ");

        }

        return frase.toString();

    }
}
