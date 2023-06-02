package com.example.blog.exception;

public class DuplicateKeyException extends RuntimeException{

    public DuplicateKeyException(String message){
        super(message);
    }

}
