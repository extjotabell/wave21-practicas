package com.bootcamp.movies.exception;

public class UserAlreadyFollowedException extends RuntimeException {
    public UserAlreadyFollowedException(String e) {
        super(e);
    }
}
