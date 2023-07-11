package com.bootcamp.movies.exception;

public class ActorNotFoundException extends RuntimeException{
    public ActorNotFoundException(String message) {
        super(message);
    }
}
