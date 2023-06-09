package com.bootcamp.grupo3.socialmeli.exception;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> postNotFoundException(PostNotFoundException e){
      return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(UserPermissionException.class)
    public ResponseEntity<?> UserPermissionException(UserPermissionException e){
      return ResponseEntity.internalServerError().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(BadPasswordException.class)
    public ResponseEntity<?> badPasswordException(BadPasswordException e){
      return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(UserNotFoundException e){
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> notFound(NoSuchElementException e){
      return ResponseEntity.badRequest().body(new MessageDTO("No se pudo encontrar el elemento"));
    }

    @ExceptionHandler(InvalidTokenFormatException.class)
    public ResponseEntity<?> userNotFoundException(InvalidTokenFormatException e){
      return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

}
