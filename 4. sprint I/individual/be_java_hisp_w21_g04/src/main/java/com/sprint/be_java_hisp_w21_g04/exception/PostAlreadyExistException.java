package com.sprint.be_java_hisp_w21_g04.exception;

public class PostAlreadyExistException extends RuntimeException{
    public PostAlreadyExistException(String message){
        super(message);
    }
}
