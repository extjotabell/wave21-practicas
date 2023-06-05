package com.EjercicioSincronico.LinkTracker.Exceptions;

public class NotFoundLinkException extends RuntimeException{
    public NotFoundLinkException(){}

    public NotFoundLinkException(String message){
        super(message);
    }

}
