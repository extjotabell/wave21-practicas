package com.example.ejercicioBlog.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class EntradaBlogExisteException extends RuntimeException{


    public EntradaBlogExisteException(String mensaje){
        super(mensaje);
    }
}
