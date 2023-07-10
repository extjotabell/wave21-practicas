package com.bootcamp.autos.exception;

public class VehiculoNotFoundException extends RuntimeException{

    public VehiculoNotFoundException(String message) {
        super(message);
    }
}
