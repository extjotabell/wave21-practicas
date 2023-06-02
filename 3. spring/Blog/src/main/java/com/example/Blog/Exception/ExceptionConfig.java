package com.example.Blog.Exception;

import com.example.Blog.Exception.ExceptionDTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
    @ExceptionHandler(BlogDuplicateException.class)
    public ResponseEntity<ErrorDTO> blogDuplicateException(BlogDuplicateException e){
        ErrorDTO errorDTO = new ErrorDTO(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
