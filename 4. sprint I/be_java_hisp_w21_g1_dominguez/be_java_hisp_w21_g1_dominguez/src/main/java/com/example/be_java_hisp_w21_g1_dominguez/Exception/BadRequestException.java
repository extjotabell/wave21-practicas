package com.example.be_java_hisp_w21_g1_dominguez.Exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){}

    public BadRequestException(String message){
        super(message);
    }
}
