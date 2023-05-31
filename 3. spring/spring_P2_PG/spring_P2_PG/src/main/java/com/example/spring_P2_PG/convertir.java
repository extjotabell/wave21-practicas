package com.example.spring_P2_PG;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class convertir {
    @GetMapping("/{numero}")
    public StringBuilder convertirNumero(@PathVariable Integer numero) {

        int[] numerosConvertir = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 2, 1};
        String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "II", "I"};

        StringBuilder romano = new StringBuilder();

        if (numero >= 4000) {
            return new StringBuilder("Numero no valido");
        } else {
            for (int i=0; i<numerosConvertir.length; i++) {
                while (numero >= numerosConvertir[i]) {
                    numero -= numerosConvertir[i];
                   romano.append(numerosRomanos[i]);
                }
            }

            return romano;

        }



    }


}
