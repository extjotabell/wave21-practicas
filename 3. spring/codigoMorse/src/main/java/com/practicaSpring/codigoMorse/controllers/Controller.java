package com.practicaSpring.codigoMorse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    @GetMapping("/{codigoMorse}")
    public String toText(@PathVariable String codigoMorse) {

        Map<String,String> codigo = new LinkedHashMap<String,String>();


        codigo.put(".-","A");
        codigo.put("-...","B");
        codigo.put("-.-.","C");
        codigo.put("-..","D");
        codigo.put(".","E");
        codigo.put("..-.","F");
        codigo.put("--.","G");
        codigo.put("....","H");
        codigo.put("..","I");
        codigo.put(".---","J");
        codigo.put("-.-","K");
        codigo.put(".-..","L");
        codigo.put("--","M");
        codigo.put("-.","N");
        codigo.put("---","O");
        codigo.put(".--.","P");
        codigo.put("--.-","Q");
        codigo.put(".-.","R");
        codigo.put("...","S");
        codigo.put("-","T");
        codigo.put("..-","U");
        codigo.put("...-","V");
        codigo.put(".--","W");
        codigo.put("-..-","X");
        codigo.put("-.--","Y");
        codigo.put("--..","Z");
        codigo.put(".----","1");
        codigo.put("..---","2");
        codigo.put("...--","3");
        codigo.put("....-","4");
        codigo.put(".....","5");
        codigo.put("-....","6");
        codigo.put("--...","7");
        codigo.put("---..","8");
        codigo.put("----.","9");
        codigo.put("-----","0");
        codigo.put(".-.-.-",".");
        codigo.put("--..--",",");
        codigo.put("..--..","?");
        codigo.put("-.-.--","!");

        StringBuilder mensaje = new StringBuilder();
        String[] palabras = codigoMorse.split("\\s{3,}");

        for (String palabra:palabras
             ) {
            String[] letras = palabra.split("\\s");
            for (String letra:letras
                 ) {
                if (codigo.get(letra)!=null) mensaje.append(codigo.get(letra));
                else mensaje.append("$");
            }
            mensaje.append(" ");
        }
        return mensaje.toString().trim();
    }
}
