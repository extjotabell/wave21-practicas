package com.example.CodigoMorse.service;

import java.util.HashMap;
import java.util.Map;

public class Servicio {

    public String convertirCodigo(String codigo) {
        String codigoConvertido = "";
        Map<String, String> morseMap = new HashMap<String, String>() {
            {
            put(".-","A");
            put("-...","B");
            put("-.-.","C");
            put("-..","D");
            put(".","E");
            put("..-.","F");
            put("--.","G");
            put("....","H");
            put("..","I");
            put(".---","J");
            put("-.-","K");
            put(".-..","L");
            put("--", "M");
            put("-.", "N");
            put("---", "O");
            put(".--.", "P");
            put("--.-", "Q");
            put(".-.", "R");
            put("...", "S");
            put("-", "T");
            put("..-", "U");
            put("...-", "V");
            put(".--", "W");
            put("-..-", "X");
            put("-.--", "Y");
            put("--..", "Z");
            put(".----", "1");
            put("..---", "2");
            put("...--", "3");
            put("....-", "4");
            put(".....", "5");
            put("-....", "6");
            put("--...", "7");
            put("---..", "8");
            put("----.", "9");
            put(".-.-.-", ".");
            put("--..--", ",");
            put("..--..", "?");
            put(".----.", "'");
            put("-.-.--", "!");
        }
    };

        String[] codigoSinEspacios = codigo.split("   ");

        for(String palabra: codigoSinEspacios){
            String[] letrasSinEspacio = palabra.split(" ");

            for(String letraEnMorse: letrasSinEspacio){
                String texto = morseMap.get(letraEnMorse);
                if(texto !=null){
                    codigoConvertido += texto;
                }
            }
            codigoConvertido += " ";
        }

        return codigoConvertido;
    }
}
