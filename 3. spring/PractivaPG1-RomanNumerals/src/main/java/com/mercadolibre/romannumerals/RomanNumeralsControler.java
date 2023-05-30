package com.mercadolibre.romannumerals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralsControler {

    @GetMapping("/home")
    public String sayHello(){
        return "Hola, soy tu primera API de Números Romanos";
    }
}
