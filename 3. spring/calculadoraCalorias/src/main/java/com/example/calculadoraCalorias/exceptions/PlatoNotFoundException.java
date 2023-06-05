package com.example.calculadoraCalorias.exceptions;


public class PlatoNotFoundException extends RuntimeException{

    public PlatoNotFoundException(String mensaje){
        super(mensaje);
    }
}
