package com.example.be_java_hisp_w21_g02.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){

    }

    public UserNotFoundException(String message){
        super(message);
    }
}
