package com.example.be_java_hisp_w21_g02.exceptions;


public class PostBadRequestException extends RuntimeException{
    public PostBadRequestException() {
    }

    public PostBadRequestException(String message) {
        super(message);
    }
}
