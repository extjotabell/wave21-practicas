package com.EjercicioSincronico.LinkTracker.Exceptions;

public class KeyAlreadyExistException extends RuntimeException{
    public KeyAlreadyExistException(){}

    public KeyAlreadyExistException(String message){
        super(message);
    }

}
