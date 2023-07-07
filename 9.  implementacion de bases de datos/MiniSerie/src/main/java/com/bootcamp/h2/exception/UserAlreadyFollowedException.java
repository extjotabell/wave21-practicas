package com.bootcamp.h2.exception;

public class UserAlreadyFollowedException extends RuntimeException {
    public UserAlreadyFollowedException(String e) {
        super(e);
    }
}
