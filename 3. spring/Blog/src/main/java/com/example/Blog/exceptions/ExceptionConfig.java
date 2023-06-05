package com.example.Blog.exceptions;

import com.example.Blog.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ErrorDTO> catchError(final BlogNotFoundException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(), HttpStatus.OK);
        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
