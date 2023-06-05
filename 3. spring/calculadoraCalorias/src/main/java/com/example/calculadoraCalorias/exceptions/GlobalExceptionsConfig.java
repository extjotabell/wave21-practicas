package com.example.calculadoraCalorias.exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsConfig {

    @ExceptionHandler
    public ResponseEntity<?> NotFoundException(Exception e){

        return ResponseEntity.status(404).body(e.getMessage());
    }
}
