package com.ejercicioSincronico.Codigo.Morse.Controllers;

import com.ejercicioSincronico.Codigo.Morse.Services.TraductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("CodigoMorse")
public class CodigoMorseController {
    @Autowired
    private TraductorService _traductor;

    @PostMapping("/traducir")
    public String traducirCodigo(@RequestBody String codigoMorse) {
        /*
         Saco los espacios al comienzo y final.
         Guardo en un arreglo separando 3 espacios consecutivos.
        */
        String[] palabras = codigoMorse.trim().split("   ");

        StringBuilder resultado = new StringBuilder();

        // Recorro el arreglo de palabras para traducirlas
        for (String palabra: palabras) {
            // Separo los caracteres
            String[] caracteres = palabra.split(" ");

            for (String caracter: caracteres) {
                // Recorro los caracteres para traducirlos
                String letra = _traductor.traducirCaracter(caracter);
                resultado.append(letra);
            }
            resultado.append(" ");
        }

        return resultado.toString().trim();
    }
}
