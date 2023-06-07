package com.example.be_java_hisp_w21_g02.exceptions;

public class UserFollowingException extends RuntimeException{
    public UserFollowingException(){
    }

    public UserFollowingException(String message){
        super(message);
    }
}
