package com.ejercicioAsincronico.numerosRomanos;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ConversorRomano {
    private static final TreeMap<Integer, String> diccionario = new TreeMap<>(Collections.reverseOrder());

    static {
        diccionario.put(1000, "M");
        diccionario.put(900, "CM");
        diccionario.put(500, "D");
        diccionario.put(400, "CD");
        diccionario.put(100, "C");
        diccionario.put(90, "XC");
        diccionario.put(50, "L");
        diccionario.put(40, "XL");
        diccionario.put(10, "X");
        diccionario.put(9, "IX");
        diccionario.put(5, "V");
        diccionario.put(4, "IV");
        diccionario.put(1, "I");
    }


    public String convertirARomano(int numero) {
        StringBuilder resultado = new StringBuilder();

        // Recorremos el map de entradas.
        for (Map.Entry<Integer, String> entrada: diccionario.entrySet()){
            // Obtengo las keys y los valores para empezar la iteraccion.
            int llave = entrada.getKey();
            String valor = entrada.getValue();

            /*
               Mientras que el numero sea mayor o igual a la llave
               voy a restar el valor hasta que la llave sea mayor al valor.
             */
            while (numero >= llave){
                resultado.append(valor);
                numero -= llave;
            }

        }

        return resultado.toString();
    }
}
