package com.sprint.be_java_hisp_w21_g04.exception;

import com.sprint.be_java_hisp_w21_g04.dto.response.ErrorDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;


import com.sprint.be_java_hisp_w21_g04.dto.response.UserNotFoundDto;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonEmpty(HttpMessageNotReadableException e){
        ErrorDto error = new ErrorDto("Error al deserializar JSON en el cuerpo de la solicitud", 400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

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

    @ExceptionHandler(UserFollowNotAllowedException.class)
    public ResponseEntity<?> userFollowNotAllowedException(Exception e){
        ErrorDto error = new ErrorDto(e.getMessage(), 400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserUnfollowNotAllowedException.class)
    public ResponseEntity<?> userUnfollowNotAllowedException(Exception e){
        ErrorDto error = new ErrorDto(e.getMessage(), 400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ErrorDto error = new ErrorDto(e.getMessage(), 404);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalDataException.class)
    public ResponseEntity<?> idNotValid(IllegalDataException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage(),400);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

}
