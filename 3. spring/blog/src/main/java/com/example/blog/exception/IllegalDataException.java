package com.example.blog.exception;

public class IllegalDataException extends RuntimeException{

    public IllegalDataException(String message){
        super(message);
    }

}