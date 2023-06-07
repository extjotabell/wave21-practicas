package com.sprint.be_java_hisp_w21_g04.exception;

public class EmptySellerFollowedList extends RuntimeException{
    public EmptySellerFollowedList(String message){
        super(message);
    }
}
