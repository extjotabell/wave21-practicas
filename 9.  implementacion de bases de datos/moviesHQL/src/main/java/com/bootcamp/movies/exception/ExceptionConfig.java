package com.bootcamp.movies.exception;

import com.bootcamp.movies.dto.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(UserAlreadyFollowedException.class)
    public ResponseEntity<?> userAlreadyFollowedException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(UserEqualsException.class)
    public ResponseEntity<?> userEqualsException(Exception e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }
}
