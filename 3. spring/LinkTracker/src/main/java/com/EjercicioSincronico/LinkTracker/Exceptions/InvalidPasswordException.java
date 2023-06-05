package com.EjercicioSincronico.LinkTracker.Exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(){}

    public InvalidPasswordException(String message){
        super(message);
    }
}
