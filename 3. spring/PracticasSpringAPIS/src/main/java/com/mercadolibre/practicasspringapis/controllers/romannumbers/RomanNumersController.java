package com.mercadolibre.practicasspringapis.controllers.romannumbers;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/romannumbers")
public class RomanNumersController {


    @GetMapping("/{number}")
    public ResponseEntity<String> converToRoman(@PathVariable int number){

        //Armo un map con las conversiones de números romanos y un String para ir armando
        StringBuilder romanNumber = new StringBuilder();

        LinkedHashMap<Integer, String> conversion = new LinkedHashMap<>();
        conversion.put(1000, "M");
        conversion.put(900, "CM");
        conversion.put(500, "D");
        conversion.put(400, "CD");
        conversion.put(100, "C");
        conversion.put(90, "XC");
        conversion.put(50, "L");
        conversion.put(40, "XL");
        conversion.put(10, "X");
        conversion.put(9, "IX");
        conversion.put(5, "V");
        conversion.put(4, "IV");
        conversion.put(1, "I");

        if (number > 3999) {
            return ResponseEntity.ok("Solo se aceptan numeros hasta 3999");
        } else

        for (Map.Entry<Integer, String> entry : conversion.entrySet()) {
            int valor = entry.getKey();
            String simbol = entry.getValue();

            while (number >= valor) {
                romanNumber.append(simbol);
                number -= valor;
            }
        }


        return ResponseEntity.ok(romanNumber.toString());
    }

}
