package com.example_consigna.consigna;

import org.springframework.stereotype.Service;

@Service
public class RomanNumeralsService {

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String convertToRomanNumeral(int number) {
        StringBuilder romanNumeral = new StringBuilder();
        for (int i = 0; i < values.length && number >= 0; i++) {
            while (values[i] <= number) {
                number -= values[i];
                romanNumeral.append(symbols[i]);
            }
        }
        return romanNumeral.toString();
    }
}
