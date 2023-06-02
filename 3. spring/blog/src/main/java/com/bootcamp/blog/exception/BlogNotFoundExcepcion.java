package com.bootcamp.blog.exception;

public class BlogNotFoundExcepcion extends RuntimeException{

    public BlogNotFoundExcepcion(String message){
        super(message);
    }
}
