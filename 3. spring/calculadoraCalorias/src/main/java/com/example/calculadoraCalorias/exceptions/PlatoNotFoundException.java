package com.example.calculadoraCalorias.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class NotFoundException extends RuntimeException{

    NotFoundException(String mensaje){
        super(mensaje);
    }
}
