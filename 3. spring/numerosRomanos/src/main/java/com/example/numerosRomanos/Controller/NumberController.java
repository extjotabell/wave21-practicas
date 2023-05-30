package com.example.numerosRomanos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.example.numerosRomanos.Clases.DecimalToRoman.convertDecimalToRoman;

@RestController
public class NumberController {

    Map<String, Integer> tabla = new HashMap<>();


    @GetMapping("/api/{decimal}")
    //1560
    //
    //
    //
    //

    public String api(@PathVariable String decimal){
        String numeroDecimal = decimal;
        String numeroRomano = convertDecimalToRoman(numeroDecimal);
        return numeroRomano;





    }
}
