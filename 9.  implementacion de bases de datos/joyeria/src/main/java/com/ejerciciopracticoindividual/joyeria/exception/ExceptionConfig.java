package com.ejerciciopracticoindividual.joyeria.exception;

import com.ejerciciopracticoindividual.joyeria.dto.ErrorDTO;
import com.ejerciciopracticoindividual.joyeria.dto.MessageDTO;
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
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentCatch(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> capturandoValidaciones(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new ErrorDTO(
                        "Se encontraron los siguientes errores en las validaciones: ",
                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList()
                )
        );
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> capturandoValidaciones(HttpMessageNotReadableException e) {
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
