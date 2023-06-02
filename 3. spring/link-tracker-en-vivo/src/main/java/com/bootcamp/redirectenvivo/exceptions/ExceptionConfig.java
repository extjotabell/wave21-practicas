package com.bootcamp.redirectenvivo.exceptions;

import com.bootcamp.redirectenvivo.dto.response.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<?> linkNotFoundException(Exception e){
        ResponseErrorDTO errorDTO = new ResponseErrorDTO(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(LinkPasswordException.class)
    public ResponseEntity<?> linkPasswordException(Exception e){
        ResponseErrorDTO errorDTO = new ResponseErrorDTO(HttpStatus.UNAUTHORIZED, e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDTO);
    }
}
