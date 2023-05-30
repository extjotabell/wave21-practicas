package com.morse.service;

import com.morse.controller.MorseCodeController;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseCodeService {
    private Map<String, Character> dictionary = new HashMap<>();

    public MorseCodeService(){
        dictionary.put(".-", 'A');
        dictionary.put("-...", 'B');
        dictionary.put("-.-.", 'C');
        dictionary.put("-..", 'D');
        dictionary.put(".", 'E');
        dictionary.put("..-.", 'F');
        dictionary.put("--.", 'G');
        dictionary.put("....", 'H');
        dictionary.put("..", 'I');
        dictionary.put(".---", 'J');
        dictionary.put("-.-", 'K');
        dictionary.put(".-..", 'L');
        dictionary.put("--", 'M');
        dictionary.put("-.", 'N');
        dictionary.put("---", 'O');
        dictionary.put(".--.", 'P');
        dictionary.put("--.-", 'Q');
        dictionary.put(".-.", 'R');
        dictionary.put("...", 'S');
        dictionary.put("-", 'T');
        dictionary.put("..-", 'U');
        dictionary.put("...-", 'V');
        dictionary.put(".--", 'W');
        dictionary.put("-..-", 'X');
        dictionary.put("-.--", 'Y');
        dictionary.put("--..", 'Z');
        dictionary.put("-----", '0');
        dictionary.put(".----", '1');
        dictionary.put("..---", '2');
        dictionary.put("...--", '3');
        dictionary.put("....-", '4');
        dictionary.put(".....", '5');
        dictionary.put("-....", '6');
        dictionary.put("--...", '7');
        dictionary.put("---..", '8');
        dictionary.put("----.", '9');
        dictionary.put("..--..", '?');
        dictionary.put(".-.-.-", '.');
        dictionary.put("-.-.--", '!');
        dictionary.put("--..--", ',');
    }
    public String parse(String phrase){
        StringBuilder result = new StringBuilder();

        for (String word: phrase.split("\\s{3}")) {
            for (String letter: word.split("\\s")) {
                if(dictionary.containsKey(letter)){
                    result.append(dictionary.get(letter));
                }
            }

            result.append(" ");
        }
        return result.toString();
    }
}
