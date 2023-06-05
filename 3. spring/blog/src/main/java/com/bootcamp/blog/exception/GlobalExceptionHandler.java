package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RepetedBlogEntryException.class)
    public ResponseEntity<ErrorDTO> handleRepeatedBlogEntryException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(),HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
