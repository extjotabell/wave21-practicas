package com.practicaSpring.ejercicioBlog.exception;

public class DuplicateKeyException extends RuntimeException{

    public DuplicateKeyException(String message){
        super(message);
    }

}
