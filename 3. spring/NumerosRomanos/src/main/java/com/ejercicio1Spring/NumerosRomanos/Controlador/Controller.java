package com.ejercicio1Spring.NumerosRomanos.Controlador;

import com.ejercicio1Spring.NumerosRomanos.Services.Servicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Servicio servicio = new Servicio();

    @GetMapping("/{numero}")
    public String convertirNumeroDecimalARomano(@PathVariable int numero){
        String numeroRomano = servicio.convertirARomano(numero);
        return numeroRomano;
    }

}
