package com.bootcamp.starWars.exception;

public class NoCharacterFoundException extends RuntimeException{

    public NoCharacterFoundException(String message){
        super(message);
    }
}
