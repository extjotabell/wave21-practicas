package com.example.Blog.Exception;

public class BlogDuplicateException extends RuntimeException{
    public BlogDuplicateException(String message) {
        super(message);
    }

    public BlogDuplicateException() {
    }
}
