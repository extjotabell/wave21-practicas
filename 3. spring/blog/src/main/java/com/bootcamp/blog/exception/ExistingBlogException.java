package com.bootcamp.blog.exception;

public class ExistingBlogException extends RuntimeException{

    public ExistingBlogException(String message){
        super(message);
    }
}
