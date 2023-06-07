package com.example.be_java_hisp_w21_g02.exceptions;

public class UserNotSellerException extends RuntimeException {
    public UserNotSellerException(){
    }

    public UserNotSellerException(String message){
        super(message);
    }
}
