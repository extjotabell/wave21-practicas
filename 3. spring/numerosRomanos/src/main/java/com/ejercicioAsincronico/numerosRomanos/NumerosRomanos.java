package com.ejercicioAsincronico.numerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("NumerosRomanos")
public class NumerosRomanos {

    private ConversorRomano conversor = new ConversorRomano();

    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable int numero) {
        String resultado = "";
        if (numero <= 3999 && numero > 0) {
            resultado = conversor.convertirARomano(numero);
        }
        else{
            resultado = "El numero ingresado debe ser menor a 4000";
        }
        return resultado;
    }
}
