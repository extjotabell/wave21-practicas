package com.EjercicioSincronico.LinkTracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(NotFoundLinkException.class)
    public ResponseEntity<?> notFoundLinkException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<?> invalidPasswordException(Exception e){
        // Mejorar mensaje
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InvalidLinkStatusException.class)
    public ResponseEntity<?> invalidLinkStatusException(Exception e){
        // Mejorar mensaje
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(KeyAlreadyExistException.class)
    public ResponseEntity<?> keyAlreadyExistException(Exception e){
        // Mejorar mensaje
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
