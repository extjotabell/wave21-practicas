package com.bootcamp.morse.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@Service
public class MorseService {

    HashMap<String, String> morseToSpanish;

    public MorseService() {
        morseToSpanish = new HashMap<>();
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
        morseToSpanish.put("-.-.--", "!");
        morseToSpanish.put("..--..", "?");
        morseToSpanish.put("--..--", ",");
        morseToSpanish.put(".-.-.-", ".");
    }

    public String parse(String morse) {
        List<String> words = Arrays.stream(morse.split("   ")).toList();

        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            List<String> characters = Arrays.stream(word.split(" ")).toList();
            for (String character : characters) {
                if (morseToSpanish.containsKey(character)) {
                    stringBuilder.append(morseToSpanish.get(character));
                } else return "El mensaje no se puede traducir";
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
