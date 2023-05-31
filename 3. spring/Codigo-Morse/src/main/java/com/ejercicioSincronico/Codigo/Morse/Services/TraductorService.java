package com.ejercicioSincronico.Codigo.Morse.Services;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TraductorService {
    private static final HashMap<String, String> diccionarioLetras = new HashMap<>();

    static {
        // Mapeo de caracteres de codigo Morse a su equivalente
        diccionarioLetras.put(".-", "A");
        diccionarioLetras.put("-...", "B");
        diccionarioLetras.put("-.-.", "C");
        diccionarioLetras.put("-..", "D");
        diccionarioLetras.put(".", "E");
        diccionarioLetras.put("..-.", "F");
        diccionarioLetras.put("--.", "G");
        diccionarioLetras.put("....", "H");
        diccionarioLetras.put("..", "I");
        diccionarioLetras.put(".---", "J");
        diccionarioLetras.put("-.-", "K");
        diccionarioLetras.put(".-..", "L");
        diccionarioLetras.put("--", "M");
        diccionarioLetras.put("-.", "N");
        diccionarioLetras.put("---", "O");
        diccionarioLetras.put(".--.", "P");
        diccionarioLetras.put("--.-", "Q");
        diccionarioLetras.put(".-.", "R");
        diccionarioLetras.put("...", "S");
        diccionarioLetras.put("-", "T");
        diccionarioLetras.put("..-", "U");
        diccionarioLetras.put("...-", "V");
        diccionarioLetras.put(".--", "W");
        diccionarioLetras.put("-..-", "X");
        diccionarioLetras.put("-.--", "Y");
        diccionarioLetras.put("--..", "Z");
        diccionarioLetras.put("-----", "0");
        diccionarioLetras.put(".----", "1");
        diccionarioLetras.put("..---", "2");
        diccionarioLetras.put("...--", "3");
        diccionarioLetras.put("....-", "4");
        diccionarioLetras.put(".....", "5");
        diccionarioLetras.put("-....", "6");
        diccionarioLetras.put("--...", "7");
        diccionarioLetras.put("---..", "8");
        diccionarioLetras.put("----.", "9");
        diccionarioLetras.put("..--..", "?");
        diccionarioLetras.put("--..--", ",");
        diccionarioLetras.put(".-.-.-", ".");
        diccionarioLetras.put("-.-.--", "!");
    }

    public String traducirCaracter(String caracter) {
        return diccionarioLetras.getOrDefault(caracter, "^");
    }
}
