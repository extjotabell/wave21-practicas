package com.sprint.be_java_hisp_w21_g04.exception;

import com.sprint.be_java_hisp_w21_g04.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.sprint.be_java_hisp_w21_g04.dto.response.UserNotFoundDto;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> hadleJsonEmty(HttpMessageNotReadableException e){
        ErrorDto error = new ErrorDto("Error al deserializar JSON en el cuerpo de la solicitud", 400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> generalException(Exception e){
//        ErrorDto error = new ErrorDto(e.getMessage(), 500);
//        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e){
        UserNotFoundDto userNotFoundDto = new UserNotFoundDto(e.getMessage(), 404);
        return new ResponseEntity<>(userNotFoundDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyFollowedException.class)
    public ResponseEntity<?> userAlreadyFollowedException(Exception e){
        ErrorDto error = new ErrorDto(e.getMessage(), 400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFollowedException.class)
    public ResponseEntity<?> userNotFollowedException(Exception e){
        ErrorDto error = new ErrorDto(e.getMessage(), 400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
