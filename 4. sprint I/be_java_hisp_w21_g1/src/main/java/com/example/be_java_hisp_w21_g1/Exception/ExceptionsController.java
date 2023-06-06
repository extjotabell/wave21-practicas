package com.example.be_java_hisp_w21_g1.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> notFoundException(Exception e, WebRequest request){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> badRequestException(Exception e, WebRequest request){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
