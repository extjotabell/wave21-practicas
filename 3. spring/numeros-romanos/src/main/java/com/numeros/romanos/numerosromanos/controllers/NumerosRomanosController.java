package com.numeros.romanos.numerosromanos.controllers;

import com.numeros.romanos.numerosromanos.services.NumerosRomanosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejercicio/numerosRomanos")
public class NumerosRomanosController {

    @GetMapping("/{numero}")
    public String getNumeroRomanoController(@PathVariable int numero){

        return NumerosRomanosService.getNumeroRomano(numero);
    }
}
