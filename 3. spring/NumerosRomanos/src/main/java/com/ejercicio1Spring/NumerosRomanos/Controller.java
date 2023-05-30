package com.ejercicio1Spring.NumerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Model model = new Model();

    @GetMapping("/{numero}")
    public String convertirNumeroDecimalARomano(@PathVariable int numero){
        String numeroRomano = model.convertirARomano(numero);
        return numeroRomano;
    }

}
