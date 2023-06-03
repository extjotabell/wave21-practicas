package com.example.EdadesPorRuta.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


public class BadRequestException extends RuntimeException{

    public BadRequestException(){

    }
    public BadRequestException(String message){
        super(message);
    }

}
