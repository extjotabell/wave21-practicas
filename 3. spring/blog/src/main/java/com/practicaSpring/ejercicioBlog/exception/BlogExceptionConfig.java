package com.practicaSpring.ejercicioBlog.exception;

import com.practicaSpring.ejercicioBlog.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogExceptionConfig {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<?> idDuplicate(DuplicateKeyException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage(),409);
        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> blogNotFound(NotFoundException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage(),404);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalDataException.class)
    public ResponseEntity<?> idNotValid(IllegalDataException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage(),400);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

}
