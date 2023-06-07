package com.example.be_java_hisp_w21_g02.exceptions.inidvidual;

public class UserNotFoundToAddException extends RuntimeException {
    public UserNotFoundToAddException() {
    }

    public UserNotFoundToAddException(String message) {
        super(message);
    }
}