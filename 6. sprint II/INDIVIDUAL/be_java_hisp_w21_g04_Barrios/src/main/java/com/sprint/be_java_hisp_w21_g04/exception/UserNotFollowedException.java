package com.sprint.be_java_hisp_w21_g04.exception;

public class UserNotFollowedException extends RuntimeException {
    public UserNotFollowedException(String message) {
        super(message);
    }
}
