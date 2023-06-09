package com.otenerdiploma.OtenerDiploma.exception;

import com.otenerdiploma.OtenerDiploma.dto.ResponseDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex){
        ResponseDto response = new ResponseDto();
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMessages = new ArrayList<>(bindingResult.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList());

        errorMessages.addAll(bindingResult.getGlobalErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());

        response.setMessage(errorMessages.toString());
        response.setStatus(400);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ResponseDto> handleValidationExceptions1(HttpMessageNotReadableException ex){
        ResponseDto response = new ResponseDto(ex.getMessage(), 400);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
