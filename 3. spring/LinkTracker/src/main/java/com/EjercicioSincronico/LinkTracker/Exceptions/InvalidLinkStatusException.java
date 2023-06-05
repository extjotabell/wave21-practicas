package com.EjercicioSincronico.LinkTracker.Exceptions;

public class InvalidLinkStatusException extends RuntimeException {
    public InvalidLinkStatusException(){}

    public InvalidLinkStatusException(String message){
        super(message);
    }
}
