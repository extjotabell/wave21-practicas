package com.example.be_java_hisp_w21_g1.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){}

    public NotFoundException(String message){
        super(message);
    }
}
