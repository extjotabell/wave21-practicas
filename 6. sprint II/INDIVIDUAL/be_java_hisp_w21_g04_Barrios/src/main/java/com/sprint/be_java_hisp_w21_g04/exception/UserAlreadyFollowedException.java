package com.sprint.be_java_hisp_w21_g04.exception;

public class UserAlreadyFollowedException extends RuntimeException {
    public UserAlreadyFollowedException(String message) {
        super(message);
    }
}
