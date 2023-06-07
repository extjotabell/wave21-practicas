package com.example.be_java_hisp_w21_g02.exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(){
    }

    public PostNotFoundException(String message){
        super(message);
    }
}
