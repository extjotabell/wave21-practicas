package com.example.be_java_hisp_w21_g1.Exception;

import com.example.be_java_hisp_w21_g1.DTO.Error.ErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionsController extends ResponseEntityExceptionHandler {
    private  ErrorDTO errorDTO = new ErrorDTO();
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> notFoundException(NotFoundException e, WebRequest request){
        errorDTO.setExplanation(e.getMessage());
        return handleExceptionInternal(e, errorDTO, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> badRequestException(BadRequestException e, WebRequest request){
        errorDTO.setExplanation(e.getMessage());
        return handleExceptionInternal(e, errorDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(UserNotSellerException.class)
    protected ResponseEntity<Object> userNotSellerException(UserNotSellerException e, WebRequest request){
        errorDTO.setExplanation(e.getMessage());
        return handleExceptionInternal(e, errorDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
