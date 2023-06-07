package com.example.be_java_hisp_w21_g02.exceptions.inidvidual;

public class PromoBadRequestException extends RuntimeException{
   //INDIVIDUAL US0010
    public PromoBadRequestException() {
    }

    public PromoBadRequestException(String message) {
        super(message);
    }
}