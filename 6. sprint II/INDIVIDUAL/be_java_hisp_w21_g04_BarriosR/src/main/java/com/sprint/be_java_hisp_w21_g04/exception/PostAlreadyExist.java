package com.sprint.be_java_hisp_w21_g04.exception;

public class PostAlreadyExist extends RuntimeException{
    public PostAlreadyExist(String message){
        super(message);
    }
}
