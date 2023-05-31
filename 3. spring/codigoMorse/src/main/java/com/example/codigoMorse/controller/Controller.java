package com.example.codigoMorse.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/morse")
public class Controller {

    @GetMapping("{codigo}")
    public String getPalabraFromCodigoMorse(@PathVariable String codigo){
        String letra = "";
        String letras = "";
        String[] palabras = codigo.split("   ");
        String[] temporal;
        HashMap<String, String> abecedario = generarAbedecedario();
        for(int i = 0; i < palabras.length; i ++){
            temporal = palabras[i].split(" ");
            for ( int j = 0; j < temporal.length; j ++){

                letra = abecedario.get(temporal[j]);
                    if(letra != null){
                        letras += letra;
                    }else{
                        return "No es posible decodificar el mensaje que nos enviaste";
                    }
            }
            letras += " ";
        }


        return letras;
    }



    public HashMap<String,String> generarAbedecedario(){

        HashMap<String,String> abecedario = new HashMap<>();

        abecedario.put(".-","A");
        abecedario.put("-...","B");
        abecedario.put("-.-.","C");
        abecedario.put("-..","D");
        abecedario.put(".","E");
        abecedario.put("..-.","F");
        abecedario.put("--.","G");
        abecedario.put("....","H");
        abecedario.put("..","I");
        abecedario.put(".---","J");
        abecedario.put("-.-","K");
        abecedario.put(".-..","L");
        abecedario.put("--","M");
        abecedario.put("-.","N");
        abecedario.put("---","O");
        abecedario.put(".--.","P");
        abecedario.put("--.-","Q");
        abecedario.put(".-.","R");
        abecedario.put("...","S");
        abecedario.put("-","T");
        abecedario.put("..-","U");
        abecedario.put("...-","V");
        abecedario.put(".--","W");
        abecedario.put("-..-","X");
        abecedario.put("-.--","Y");
        abecedario.put("--..","Z");
        abecedario.put(".----","1");
        abecedario.put("..---","2");
        abecedario.put("...--","3");
        abecedario.put("....-","4");
        abecedario.put(".....","5");
        abecedario.put("-.....","6");
        abecedario.put("--....","7");
        abecedario.put("---..","8");
        abecedario.put("----.","9");
        abecedario.put("-----","0");
        abecedario.put(".-.-.-",".");
        abecedario.put("--..--",",");
        abecedario.put("---...",":");
        abecedario.put("-.-.-.",";");
        abecedario.put("..--..","?");
        abecedario.put("-.-.--","!");
        abecedario.put(".-..-.", "\"");
        abecedario.put(".----.","\'");
        abecedario.put(".-.-.","+");
        abecedario.put("-....-","-");
        abecedario.put("-..-.","/");
        abecedario.put("-...-","=");

                /*
                '_': '..--.-', '$': '...-..-', '@': '.--.-.',
                '&': '.-...',  '(': '-.--.',   ')': '-.--.-'}*/

    return abecedario;
    }
}
