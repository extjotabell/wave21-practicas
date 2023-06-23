package com.bootcamp.grupo3.socialmeli.exception;

public class UserAlreadyFollowedException extends RuntimeException {
    public UserAlreadyFollowedException(String e) {
        super(e);
    }
}
