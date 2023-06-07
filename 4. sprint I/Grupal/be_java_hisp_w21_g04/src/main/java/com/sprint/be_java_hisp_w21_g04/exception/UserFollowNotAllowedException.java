package com.sprint.be_java_hisp_w21_g04.exception;

public class UserFollowNotAllowedException extends RuntimeException {
    public UserFollowNotAllowedException(String message) {
        super(message);
    }
}
