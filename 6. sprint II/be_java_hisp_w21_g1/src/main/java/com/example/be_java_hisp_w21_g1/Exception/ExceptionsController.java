package com.example.be_java_hisp_w21_g1.Exception;

import com.example.be_java_hisp_w21_g1.DTO.Error.ErrorDTO;
import com.example.be_java_hisp_w21_g1.DTO.Error.ExceptionDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionsController {
    private ErrorDTO errorDTO = new ErrorDTO();

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> notFoundException(Exception e) {
        errorDTO.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> badRequestException(Exception e) {
        errorDTO.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotSellerException.class)
    protected ResponseEntity<Object> userNotSellerException(Exception e) {
        errorDTO.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionDTO> validationException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionDTO("Se encontraron los siguientes errores: ",
                        e.getAllErrors()
                                .stream()
                                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                .toList()
                )
        );
    }
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ExceptionDTO> validationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionDTO("Se encontraron los siguientes errores: ",
                        e.getConstraintViolations()
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .collect(Collectors.toList())
                )
        );
    }
}
