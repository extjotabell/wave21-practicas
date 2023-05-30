package com.codigoMorse.codigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConversorATexto {

    Map<String, String> moseCode = new HashMap<>();

    @GetMapping("/{palabraMorse}")
    public String convertir(@PathVariable  String palabraMorse){

        moseCode.put(".-", "A");
        moseCode.put("-...", "B");
        moseCode.put("-.-.", "C");
        moseCode.put("-..", "D");
        moseCode.put(".", "E");
        moseCode.put("..-.", "F");
        moseCode.put("--.", "G");
        moseCode.put("....", "H");
        moseCode.put("..", "I");
        moseCode.put(".---", "J");
        moseCode.put("-.-", "K");
        moseCode.put(".-..", "L");
        moseCode.put("--", "M");
        moseCode.put("-.", "N");
        moseCode.put("---", "O");
        moseCode.put(".--.", "P");
        moseCode.put("--.-", "Q");
        moseCode.put(".-.", "R");
        moseCode.put("...", "S");
        moseCode.put("-", "T");
        moseCode.put("..-", "U");
        moseCode.put("...-", "V");
        moseCode.put(".--", "W");
        moseCode.put("-..-", "X");
        moseCode.put("-.--", "Y");
        moseCode.put("--..", "Z");
        moseCode.put("-----", "0");
        moseCode.put(".----", "1");
        moseCode.put("..---", "2");
        moseCode.put("...--", "3");
        moseCode.put("....-", "4");
        moseCode.put(".....", "5");
        moseCode.put("-....", "6");
        moseCode.put("--...", "7");
        moseCode.put("---..", "8");
        moseCode.put("----.", "9");
        moseCode.put(".-.-.-", ".");
        moseCode.put("--..--", ",");
        moseCode.put("..--..", "?");
        moseCode.put("-.-.--", "!");

        String palabraEnLetras = "";

        //separo por palabras
        String palabras[] = palabraMorse.split("\\s{3}");

        for (String s : palabras) {
            //entro a una palabra -> separo por caracteres

            //[....]
            String[] caracteres = s.split("\\s");

            for (int i = 0; i < caracteres.length; i++) {

                String obtenido = moseCode.get(caracteres[i]);

                if(obtenido != null) {
                    System.out.println(obtenido);
                   palabraEnLetras += obtenido;
                }else {
                    System.out.println("entre por el null");
                    palabraEnLetras += "$";
                }


            }
            palabraEnLetras += " ";

        }

        return palabraEnLetras.toString().trim();

    }




}
