package com.mercadolibre.practicasspringapis.controllers.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MorseController {

    @GetMapping("/morse/{code}")
    public String responseSpanish(@PathVariable String code){
        return translateMorseToSpanish(code)    ;
    }


    public String translateMorseToSpanish(String code){

        HashMap<String, String> morseToSpanish = new HashMap<>();
        morseToSpanish.put(".-", "A");
        morseToSpanish.put("-...", "B");
        morseToSpanish.put("-.-.", "C");
        morseToSpanish.put("-..", "D");
        morseToSpanish.put(".", "E");
        morseToSpanish.put("..-.", "F");
        morseToSpanish.put("--.", "G");
        morseToSpanish.put("....", "H");
        morseToSpanish.put("..", "I");
        morseToSpanish.put(".---", "J");
        morseToSpanish.put("-.-", "K");
        morseToSpanish.put(".-..", "L");
        morseToSpanish.put("--", "M");
        morseToSpanish.put("-.", "N");
        morseToSpanish.put("---", "O");
        morseToSpanish.put(".--.", "P");
        morseToSpanish.put("--.-", "Q");
        morseToSpanish.put(".-.", "R");
        morseToSpanish.put("...", "S");
        morseToSpanish.put("-", "T");
        morseToSpanish.put("..-", "U");
        morseToSpanish.put("...-", "V");
        morseToSpanish.put(".--", "W");
        morseToSpanish.put("-..-", "X");
        morseToSpanish.put("-.--", "Y");
        morseToSpanish.put("--..", "Z");
        morseToSpanish.put(".----", "1");
        morseToSpanish.put("..---", "2");
        morseToSpanish.put("...--", "3");
        morseToSpanish.put("....-", "4");
        morseToSpanish.put(".....", "5");
        morseToSpanish.put("-....", "6");
        morseToSpanish.put("--...", "7");
        morseToSpanish.put("---..", "8");
        morseToSpanish.put("----.", "9");
        morseToSpanish.put("-----", "0");
        morseToSpanish.put("-.-.--","!");
        morseToSpanish.put("..--..","?");
        morseToSpanish.put("--..--",",");
        morseToSpanish.put(".-.-.-",".");


        List<String> palabras= Arrays.stream(code.split("   ")).toList();

        StringBuilder traduccion = new StringBuilder();

        for (String palabra: palabras)
        {
            List<String> carateres = Arrays.stream(palabra.split(" ")).toList();

            for (String caracter: carateres) {


                if(morseToSpanish.containsKey(caracter)) {
                    traduccion.append(morseToSpanish.get(caracter));
                } else return "El mensaje no se puede traducir";
            }
            traduccion.append(" ");
        }

        return traduccion.toString().trim();
    }

}

