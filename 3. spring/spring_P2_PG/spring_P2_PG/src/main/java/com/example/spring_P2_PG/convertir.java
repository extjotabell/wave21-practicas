package com.example.spring_P2_PG;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.Arrays;
import java.util.Map;

@RestController
public class convertir {
    @GetMapping("/{numero}")
    public String convertirNumero(@PathVariable Integer numero) {

        int[] numerosConvertir = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String romano = "";

        for (int i=0; i<numerosConvertir.length; i++) {
            if(numero >= numerosConvertir[i]) {
                romano += numerosRomanos[i];
                numero -= numerosConvertir[i];
            }
        }

        return romano;
    }


}
