package com.example.codigoMorse.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    @GetMapping("/morse/{code}")
    public String morseToString(@PathVariable String code){

        Map<String, Character> morseCodeMap = new HashMap<>();

        morseCodeMap.put(".-", 'A');
        morseCodeMap.put("-...", 'B');
        morseCodeMap.put("-.-.", 'C');
        morseCodeMap.put("-..", 'D');
        morseCodeMap.put(".", 'E');
        morseCodeMap.put("..-.", 'F');
        morseCodeMap.put("--.", 'G');
        morseCodeMap.put("....", 'H');
        morseCodeMap.put("..", 'I');
        morseCodeMap.put(".---", 'J');
        morseCodeMap.put("-.-", 'K');
        morseCodeMap.put(".-..", 'L');
        morseCodeMap.put("--", 'M');
        morseCodeMap.put("-.", 'N');
        morseCodeMap.put("---", 'O');
        morseCodeMap.put(".--.", 'P');
        morseCodeMap.put("--.-", 'Q');
        morseCodeMap.put(".-.", 'R');
        morseCodeMap.put("...", 'S');
        morseCodeMap.put("-", 'T');
        morseCodeMap.put("..-", 'U');
        morseCodeMap.put("...-", 'V');
        morseCodeMap.put(".--", 'W');
        morseCodeMap.put("-..-", 'X');
        morseCodeMap.put("-.--", 'Y');
        morseCodeMap.put("--..", 'Z');
        morseCodeMap.put("-----", '0');
        morseCodeMap.put(".----", '1');
        morseCodeMap.put("..---", '2');
        morseCodeMap.put("...--", '3');
        morseCodeMap.put("....-", '4');
        morseCodeMap.put(".....", '5');
        morseCodeMap.put("-....", '6');
        morseCodeMap.put("--...", '7');
        morseCodeMap.put("---..", '8');
        morseCodeMap.put("----.", '9');
        morseCodeMap.put(".-.-.-", '.');
        morseCodeMap.put("--..--", ',');
        morseCodeMap.put("..--..", '?');
        morseCodeMap.put("-.-.--", '!');

        //
        int i = 0;
        char character ;
        StringBuilder unCodigo = new StringBuilder();
        StringBuilder fraseFinal = new StringBuilder();

        while(i < code.length() ){

            character = code.charAt(i);
            if (i == code.length() - 1) {
                // Último carácter, traducción y salida del bucle
                unCodigo.append(character);
                Character foundCode = morseCodeMap.get(unCodigo.toString());
                fraseFinal.append(foundCode);
                break;
            }
            
            if(Character.isWhitespace(character) && !Character.isWhitespace(code.charAt(i+1))){
                Character foundCode = morseCodeMap.get(unCodigo.toString());
                fraseFinal.append(foundCode);
                unCodigo.setLength(0);
                i++;
            }else if(Character.isWhitespace(character) && Character.isWhitespace(code.charAt(i+1)) && Character.isWhitespace(code.charAt(i+2))){
                Character foundCode = morseCodeMap.get(unCodigo.toString());
                fraseFinal.append(foundCode);
                fraseFinal.append(" ");
                unCodigo.setLength(0);
                i+=3;
            }else{
                unCodigo.append(character);
                i++;
            }



        }

        return fraseFinal.toString() ;

    }

}
