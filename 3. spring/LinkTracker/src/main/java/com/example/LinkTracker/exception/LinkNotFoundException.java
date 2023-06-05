package com.example.LinkTracker.exception;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(String msg) {
        super(msg);
    }
}
