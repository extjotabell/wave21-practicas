package com.bootcamp.redirectenvivo.exceptions;

public class LinkPasswordException extends RuntimeException{
    public LinkPasswordException(){}

    public LinkPasswordException(String message) {
        super(message);
    }
}
