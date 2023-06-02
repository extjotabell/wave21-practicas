package com.example.Blog.exceptions;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String msg) {
        super(msg);
    }
}
