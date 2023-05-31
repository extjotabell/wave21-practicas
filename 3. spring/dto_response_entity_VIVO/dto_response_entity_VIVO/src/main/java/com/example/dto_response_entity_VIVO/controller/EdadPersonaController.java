package com.example.dto_response_entity_VIVO.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
@RequestMapping("/")
public class EdadPersonaController {
    @GetMapping("{dia}/{mes}/{ano}")
    public String getDate(@PathVariable Integer dia,
                           @PathVariable Integer mes,
                           @PathVariable Integer ano ){

        Integer anoActual = 2023;

        boolean validarDia = dia >= 1 && dia <= 31;
        boolean validarMes = mes >= 1 && mes <= 12;
        boolean validarAño = ano <= anoActual;
        
        if (validarDia && validarMes && validarAño) {
            Integer edadActual = anoActual - ano;
            return edadActual.toString();
        } else if (!validarDia) {
            return "Dia Invalido";
        } else if (!validarMes) {
            return "Mes Invalido";
        } else {
            return "Año Invalido";
        }


    }
}
