package com.numRomanos.numerosRomanos.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Convertidor {
    /*
        1 - I
        4 - IV
        5 - V
        9 - IX
        10 - X
        40 - XL
        50 - L
        90 - XC
        100 - C
        400 - CD
        500 - D
        900 - CM
        1000 - M
     */

    private Map<Integer, Character> romanNumbers;

    public Convertidor() {
        this.romanNumbers = new HashMap<>();
        this.romanNumbers.put(1, 'I');
        this.romanNumbers.put(5, 'V');
        this.romanNumbers.put(10, 'X');
        this.romanNumbers.put(50, 'L');
        this.romanNumbers.put(100, 'C');
        this.romanNumbers.put(500, 'D');
        this.romanNumbers.put(1000, 'M');
    }

    public String conversorANumeroRomano(String numero){
        int numDigits = numero.length();

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numDigits; ++i) {
            char src = numero.charAt(i); // orig
            int number = (src - '0'); // convert to integer
            int place = (numDigits - 1) - i;
            int absolute = (int)Math.pow(10, place);
            if (number == 9) {
                res.append(romanNumbers.get(absolute));
                res.append(romanNumbers.get(absolute * 10));
            }
            else if (number >= 5) {
                res.append(romanNumbers.get(absolute * 5));
                res.append((String.valueOf(romanNumbers.get(absolute)))
                        .repeat(number - 5));
            }
            else if (number == 4) {
                res.append(romanNumbers.get(absolute));
                res.append(romanNumbers.get(absolute * 5));
            }
            else {
                res.append((String.valueOf(romanNumbers.get(absolute)))
                        .repeat(number));
            }
        }
        return res.toString();
    }
}
