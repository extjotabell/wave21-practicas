package com.sprint.be_java_hisp_w21_g04.exception;

public class UserUnfollowNotAllowedException extends RuntimeException {
    public UserUnfollowNotAllowedException(String message) {
        super(message);
    }
}
