package com.bootcamp.grupo3.socialmeli.exception;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }
}
