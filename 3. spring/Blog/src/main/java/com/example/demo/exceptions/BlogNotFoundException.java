package com.example.demo.exceptions;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String msg) {
        super(msg);
    }
}