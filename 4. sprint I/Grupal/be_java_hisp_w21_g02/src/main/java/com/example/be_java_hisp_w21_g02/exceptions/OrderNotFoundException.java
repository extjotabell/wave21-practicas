package com.example.be_java_hisp_w21_g02.exceptions;

public class OrderNotFoundException  extends RuntimeException {
    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
