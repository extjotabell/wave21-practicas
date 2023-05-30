package com.example.CodigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {
    @GetMapping("/{morse}")
    public String morseToString(@PathVariable String morse){
        StringBuilder romanNumber = new StringBuilder();
        HashMap<String,String> morseDictionary = new HashMap<>();

        morseDictionary.put(".-", "A");
        morseDictionary.put("-...", "B");
        morseDictionary.put("-.-.", "C");
        morseDictionary.put("-..", "D");
        morseDictionary.put(".", "E");
        morseDictionary.put("..-.", "F");
        morseDictionary.put("--.", "G");
        morseDictionary.put("....", "H");
        morseDictionary.put("..", "I");
        morseDictionary.put(".---", "J");
        morseDictionary.put("-.-", "K");
        morseDictionary.put(".-..", "L");
        morseDictionary.put("--", "M");
        morseDictionary.put("-.", "N");
        morseDictionary.put("---", "O");
        morseDictionary.put(".--.", "P");
        morseDictionary.put("--.-", "Q");
        morseDictionary.put(".-.", "R");
        morseDictionary.put("...", "S");
        morseDictionary.put("-", "T");
        morseDictionary.put("..-", "U");
        morseDictionary.put("...-", "V");
        morseDictionary.put(".--", "W");
        morseDictionary.put("-..-", "X");
        morseDictionary.put("-.--", "Y");
        morseDictionary.put("--..", "Z");

        morseDictionary.put("-----", "0");
        morseDictionary.put(".----", "1");
        morseDictionary.put("..---", "2");
        morseDictionary.put("...--", "3");
        morseDictionary.put("....-", "4");
        morseDictionary.put(".....", "5");
        morseDictionary.put("-....", "6");
        morseDictionary.put("--...", "7");
        morseDictionary.put("---..", "8");
        morseDictionary.put("----.", "9");

        morseDictionary.put("--..--", ",");
        morseDictionary.put(".-.-.-", ".");
        morseDictionary.put("-.-.--", "!");
        morseDictionary.put("..--..", "?");

        String[] words = morse.split("   ");
        String result = "";
        for(String word: words){
            String[] letters = word.split(" ");
            for (String letter : letters){
                result+=morseDictionary.get(letter);
            }
            result+=" ";
        }
        return result;
    }
}
