package com.example.CodigoMorse.controller;

import com.example.CodigoMorse.service.Servicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    Servicio service = new Servicio();
    @GetMapping("/{codigo}")
    public String codigoMorseConvertido(@PathVariable String codigo){
        String codigoConvertido = service.convertirCodigo(codigo);
        return codigoConvertido;
    }

}
