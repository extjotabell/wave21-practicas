package com.example.numerosRomanos.Clases;

import java.util.LinkedHashMap;
import java.util.Map;

public class DecimalToRoman {
    private static final Map<Integer, String> romanosMap = new LinkedHashMap<>();

    static {
        romanosMap.put(1000, "M");
        romanosMap.put(900, "CM");
        romanosMap.put(500, "D");
        romanosMap.put(400, "CD");
        romanosMap.put(100, "C");
        romanosMap.put(90, "XC");
        romanosMap.put(50, "L");
        romanosMap.put(40, "XL");
        romanosMap.put(10, "X");
        romanosMap.put(9, "IX");
        romanosMap.put(5, "V");
        romanosMap.put(4, "IV");
        romanosMap.put(1, "I");
    }
    //41
    //
    public static String convertDecimalToRoman(String decimal) {
        int numero = Integer.parseInt(decimal); //41-
        StringBuilder resultado = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanosMap.entrySet()) {
            int valorDecimal = entry.getKey(); //
            String valorRomano = entry.getValue(); //M

            while (numero >= valorDecimal) {
                resultado.append(valorRomano);
                numero -= valorDecimal;
            }
        }

        return resultado.toString();

    }
}
