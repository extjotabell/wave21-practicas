package com.ejercicio2.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.Iterator;

@RestController
public class MorseController {
    @GetMapping("/{morse}")
    public String morseToString(@PathVariable(value = "morse") String morse) {
        return parseMorse(morse);
    }

    private String parseMorse(String morse) {
        StringBuilder str = new StringBuilder();
        String[] letras = morse.split(" ");
        int cont=0;
        Iterator<String> iteratorLetras = Arrays.stream(letras).iterator();
        while (iteratorLetras.hasNext()) {
            String letraActual=iteratorLetras.next();
            switch (letraActual) {
                case "":
                    cont++;
                    if(cont==2){
                        str.append(" ");
                        cont=0;
                    }
                    break;
                case "···−−−···":
                    str.append("SOS");
                    break;
                case ".-":
                    str.append("A");
                    break;
                case "-...":
                    str.append("B");
                    break;
                case "-.-.":
                    str.append("C");
                    break;
                case "-..":
                    str.append("D");
                    break;
                case ".":
                    str.append("E");
                    break;
                case "..-.":
                    str.append("F");
                    break;
                case "--.":
                    str.append("G");
                    break;
                case "....":
                    str.append("H");
                    break;
                case "..":
                    str.append("I");
                    break;
                case ".---":
                    str.append("J");
                    break;
                case "-.-":
                    str.append("K");
                    break;
                case ".-..":
                    str.append("L");
                    break;
                case "--":
                    str.append("M");
                    break;
                case "-.":
                    str.append("N");
                    break;
                case "---":
                    str.append("O");
                    break;
                case ".--.":
                    str.append("P");
                    break;
                case "--.-":
                    str.append("Q");
                    break;
                case ".-.":
                    str.append("R");
                    break;
                case "...":
                    str.append("S");
                    break;
                case "-":
                    str.append("T");
                    break;
                case "..-":
                    str.append("U");
                    break;
                case "...-":
                    str.append("V");
                    break;
                case ".--":
                    str.append("W");
                    break;
                case "-..-":
                    str.append("X");
                    break;
                case "-.--":
                    str.append("Y");
                    break;
                case "--..":
                    str.append("Z");
                    break;
                case ".----":
                    str.append("1");
                    break;
                case "..---":
                    str.append("2");
                    break;
                case "...--":
                    str.append("3");
                    break;
                case "....-":
                    str.append("4");
                    break;
                case ".....":
                    str.append("5");
                    break;
                case "..--..":
                    str.append("?");
                    break;
                case "-.-.--":
                    str.append("!");
                    break;
                case "-....":
                    str.append("6");
                    break;
                case "--...":
                    str.append("7");
                    break;
                case "---..":
                    str.append("8");
                    break;
                case "----.":
                    str.append("9");
                    break;
                case "-----":
                    str.append("0");
                    break;
                case ".-.-.-":
                    str.append(".");
                    break;
                case "--..--":
                    str.append(",");
                    break;
                default:
                    return "Ingrese algo correcto";
            }
            if(!letraActual.equals(""))
                cont=0;
        }
        return str.toString();
    }
}
