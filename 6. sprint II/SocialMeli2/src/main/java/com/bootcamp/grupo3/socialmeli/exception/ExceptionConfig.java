package com.bootcamp.grupo3.socialmeli.exception;

import com.bootcamp.grupo3.socialmeli.dto.response.ErrorDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e) {
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(UserAlreadyFollowedException.class)
    public ResponseEntity<?> userAlreadyFollowedException(Exception e) {
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(UserEqualsException.class)
    public ResponseEntity<?> userEqualsException(Exception e) {
        return ResponseEntity.badRequest().body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new ErrorDTO(
                        "Se encontraron los siguientes errores en las validaciones: ",
                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList()
                )
        );
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> validationException(HttpMessageNotReadableException e) {
        MessageDTO errorDto = new MessageDTO(e.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> validationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(
                new ErrorDTO(
                        "Se encontraron los siguientes errores en las validaciones: ",
                        e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
                )
        );


    }
}