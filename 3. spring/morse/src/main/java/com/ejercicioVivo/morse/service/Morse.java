package com.ejercicioVivo.morse.service;

import java.util.HashMap;

public class Morse {
    private static HashMap <String, Character> tablaTraduccion = new HashMap<>(){{
        put(".-", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');
        put("-----", '0');
        put(".----", '1');
        put("..---", '2');
        put("...--", '3');
        put("....-", '4');
        put(".....", '5');
        put("-....", '6');
        put("--...", '7');
        put("---..", '8');
        put("----.", '9');
        put("..--..", '?');
        put(".-.-.-", '.');
        put("-.-.--", '!');
        put("--..--", ',');


    }};


    public static String transformarAtexto(String morse){
        String[] letrasEnMorse = morse.split("(?<! ) |(?<= {3})");
        StringBuilder traduccion = new StringBuilder();
        boolean error = false;
        int contador = 0;
        String letraEnMorse;
        while(contador < letrasEnMorse.length && !error){
            letraEnMorse = letrasEnMorse[contador];
            if(letraEnMorse.equals("  ")){
                traduccion.append(" ");
            }else{
                try{
                    char letra = tablaTraduccion.get(letraEnMorse);
                    traduccion.append(letra);

                }catch (NullPointerException e){
                    error = true;
                    traduccion.replace(0, traduccion.length(),"El codigo ingresado no es morse");
                }
            }
            contador++;
        }

        return traduccion.toString();
    }
}
