package com.practicaSpring.ejercicioBlog.exception;

public class IllegalDataException extends RuntimeException{

    public IllegalDataException(String message){
        super(message);
    }

}