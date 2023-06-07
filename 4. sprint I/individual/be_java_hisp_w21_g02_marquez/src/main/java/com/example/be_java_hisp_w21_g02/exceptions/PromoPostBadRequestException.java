package com.example.be_java_hisp_w21_g02.exceptions;

public class PromoPostBadRequestException extends RuntimeException {
    public PromoPostBadRequestException() {
    }

    public PromoPostBadRequestException(String message) {
        super(message);
    }
}
