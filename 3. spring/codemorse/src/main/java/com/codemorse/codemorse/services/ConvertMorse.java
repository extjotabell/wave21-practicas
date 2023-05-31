package com.codemorse.codemorse.Services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMorse {
    private static Map<String, String> codigosMorse;

    public ConvertMorse() {
        codigosMorse = new HashMap<>();
        codigosMorse.put(".-", "A");
        codigosMorse.put("-...", "B");
        codigosMorse.put("-.-.", "C");
        codigosMorse.put("-..", "D");
        codigosMorse.put(".", "E");
        codigosMorse.put("..-.", "F");
        codigosMorse.put("--.", "G");
        codigosMorse.put("....", "H");
        codigosMorse.put("..", "I");
        codigosMorse.put(".---", "J");
        codigosMorse.put("-.-", "K");
        codigosMorse.put(".-..", "L");
        codigosMorse.put("--", "M");
        codigosMorse.put("-.", "N");
        codigosMorse.put("---", "O");
        codigosMorse.put(".--.", "P");
        codigosMorse.put("--.-", "Q");
        codigosMorse.put(".-.", "R");
        codigosMorse.put("...", "S");
        codigosMorse.put("-", "T");
        codigosMorse.put("..-", "U");
        codigosMorse.put("...-", "V");
        codigosMorse.put(".--", "W");
        codigosMorse.put("-..-", "X");
        codigosMorse.put("-.--", "Y");
        codigosMorse.put("--..", "Z");
        codigosMorse.put(".----", "1");
        codigosMorse.put("..---", "2");
        codigosMorse.put("...--", "3");
        codigosMorse.put("....-", "4");
        codigosMorse.put(".....", "5");
        codigosMorse.put("-.....", "6");
        codigosMorse.put("--...", "7");
        codigosMorse.put("---..", "8");
        codigosMorse.put("----.", "9");
        codigosMorse.put("-----", "0");
        codigosMorse.put("..--..", "?");
        codigosMorse.put("-.-.--", "!");
        codigosMorse.put(".-.-.-", ".");
        codigosMorse.put("--..--", ",");
    }

    public String convertToMorse(String codigoMorse){
        return Arrays.stream(codigoMorse.split("   ")).map(palabra -> Arrays.stream(palabra.split(" "))
                .map(letra -> {
                    if(!codigosMorse.containsKey(letra)){
                        return "No se pudo covertir a morse";
                    }
                    return codigosMorse.get(letra);
                }).collect(Collectors.joining())).collect(Collectors.joining(" "));
    }
}

