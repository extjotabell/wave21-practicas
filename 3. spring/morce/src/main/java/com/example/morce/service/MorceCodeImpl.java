package com.example.morce.service;

import org.apache.el.stream.Stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorceCodeImpl implements MorceService{
    @Override
    public String convertToMorceCode(String code) {
        Map<String, String> morseCodeMap = new HashMap<>();
        StringBuilder translation = new StringBuilder();

        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
        morseCodeMap.put("-----", "0");
        morseCodeMap.put("-.-.--","!");
        morseCodeMap.put("..--..","?");
        morseCodeMap.put("--..--",",");
        morseCodeMap.put(".-.-.-",".");

        List<String> words = Arrays.stream(code.split("   ")).toList();
        for (String p: words){
            List<String> characters = Arrays.stream(p.split(" ")).toList();
            for (String c: characters){
                if(morseCodeMap.containsKey(c)){
                    translation.append(morseCodeMap.get(c));
                }
                else
                    return "El mensaje no se puede codificar";
            }
            translation.append("");
        }

        return translation.toString().trim();
    }
}
