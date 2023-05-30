package com.practicaSpring.codigoMorse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/{codMorse}")
    public String convertirMosrse(@PathVariable String codMorse) {

        Map<String, String> codigo = new LinkedHashMap<>();

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
        codigo.put(".----.","'");
        codigo.put("-....-","-");
        codigo.put("-..-.","/");
        codigo.put(".-..-.","\"");
        codigo.put(".--.-.","@");
        codigo.put("-...-","=");
        codigo.put("   "," ");

        String[] palabras = codMorse.split("\\s{3,}");
        StringBuilder mensaje = new StringBuilder();

        for (String palabra : palabras) {
            String[] letras = palabra.split("\\s");

            for (String letra : letras) {

                if (codigo.get(letra) != null) {
                    mensaje.append(codigo.get(letra));
                }else {
                    return "Codigo no valido";
                }
            }
            mensaje.append(" ");
        }

        return mensaje.toString().trim();
    }


}
