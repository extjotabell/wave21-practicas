package com.mercadolibre.blog.exceptions;

public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException(){

    }

    public BlogNotFoundException(String message){
        super(message);
    }
}
