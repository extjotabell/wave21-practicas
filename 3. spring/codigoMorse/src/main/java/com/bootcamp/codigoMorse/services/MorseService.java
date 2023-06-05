package com.bootcamp.codigoMorse.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MorseService {

    Map<String, String> fromMorseToSpanish;

    public MorseService() {
        fromMorseToSpanish = new HashMap<>();
        fromMorseToSpanish.put(".-", "A");
        fromMorseToSpanish.put("-...", "B");
        fromMorseToSpanish.put("-.-.", "C");
        fromMorseToSpanish.put("-..", "D");
        fromMorseToSpanish.put(".", "E");
        fromMorseToSpanish.put("..-.", "F");
        fromMorseToSpanish.put("--.", "G");
        fromMorseToSpanish.put("....", "H");
        fromMorseToSpanish.put("..", "I");
        fromMorseToSpanish.put(".---", "J");
        fromMorseToSpanish.put("-.-", "K");
        fromMorseToSpanish.put(".-..", "L");
        fromMorseToSpanish.put("--", "M");
        fromMorseToSpanish.put("-.", "N");
        fromMorseToSpanish.put("---", "O");
        fromMorseToSpanish.put(".--.", "P");
        fromMorseToSpanish.put("--.-", "Q");
        fromMorseToSpanish.put(".-.", "R");
        fromMorseToSpanish.put("...", "S");
        fromMorseToSpanish.put("-", "T");
        fromMorseToSpanish.put("..-", "U");
        fromMorseToSpanish.put("...-", "V");
        fromMorseToSpanish.put(".--", "W");
        fromMorseToSpanish.put("-..-", "X");
        fromMorseToSpanish.put("-.--", "Y");
        fromMorseToSpanish.put("--..", "Z");
        fromMorseToSpanish.put(".----", "1");
        fromMorseToSpanish.put("..---", "2");
        fromMorseToSpanish.put("...--", "3");
        fromMorseToSpanish.put("....-", "4");
        fromMorseToSpanish.put(".....", "5");
        fromMorseToSpanish.put("-....", "6");
        fromMorseToSpanish.put("--...", "7");
        fromMorseToSpanish.put("---..", "8");
        fromMorseToSpanish.put("----.", "9");
        fromMorseToSpanish.put("-----", "0");
        fromMorseToSpanish.put("-.-.--", "!");
        fromMorseToSpanish.put("..--..", "?");
        fromMorseToSpanish.put("--..--", ",");
        fromMorseToSpanish.put(".-.-.-", ".");
    }

    public String parseMorse(String morseCode) {
        StringBuilder stringBuilder = new StringBuilder();

        //Lista de palabras en codigo Morse
        List<String> morseWords = Arrays.stream(morseCode.split("   ")).toList(); //Tres espacios

        for (String word : morseWords) {
            //Lista de caracteres de cada palabra en codigo Morse
            List<String> characters = Arrays.stream(word.split(" ")).toList(); //Un espacio

            for (String character : characters) {
                if (fromMorseToSpanish.containsKey(character)) {
                    stringBuilder.append(fromMorseToSpanish.get(character));
                } else return "No se encontraron los caracteres Morse en el diccionario Morse-Español provisto.";
            }
            stringBuilder.append(" "); //Agrego el espacio para separar palabras
        }
        return stringBuilder.toString().trim(); //Saco los espacios del final
    }
}
