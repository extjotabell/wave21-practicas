package com.bootcamp.blogenvivo.exceptions;

public class ExistedBlogException extends RuntimeException{

    public ExistedBlogException(){

    }

    public ExistedBlogException(String message){
        super(message);
    }
}