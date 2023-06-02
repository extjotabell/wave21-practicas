package com.bootcamp.blogenvivo.exceptions;

import com.bootcamp.blogenvivo.dto.responseDTO.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<?> blogNotFoundException(Exception e){
        ResponseErrorDTO errorDTO = new ResponseErrorDTO(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(ExistedBlogException.class)
    public ResponseEntity<?> existedBlogException(Exception e){
        ResponseErrorDTO errorDTO = new ResponseErrorDTO(HttpStatus.CONFLICT, e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDTO);
    }

}