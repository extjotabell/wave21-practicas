package com.example.be_java_hisp_w21_g1.Exception;

public class UserNotSellerException extends RuntimeException{
    public UserNotSellerException() {
    }

    public UserNotSellerException(String message) {
        super(message);
    }
}
