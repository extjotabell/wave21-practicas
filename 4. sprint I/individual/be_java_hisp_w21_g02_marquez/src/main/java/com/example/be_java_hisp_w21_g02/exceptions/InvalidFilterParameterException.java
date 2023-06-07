package com.example.be_java_hisp_w21_g02.exceptions;

public class InvalidFilterParameterException extends RuntimeException {
    public InvalidFilterParameterException() {
    }

    public InvalidFilterParameterException(String message) {
        super(message);
    }
}
