package com.example.recapitulando_spring_P2_VIVO.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
    }
    public BadRequestException(String message) {
        super(message);
    }
}
