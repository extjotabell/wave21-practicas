package com.example.be_java_hisp_w21_g02.exceptions;

import com.example.be_java_hisp_w21_g02.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(UserNotSellerException.class)
    public ResponseEntity<?> userNotSellerException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(UserFollowingException.class)
    public ResponseEntity<?> UserFollowingException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(PostBadRequestException.class)
    public ResponseEntity<?> PostBadRequestException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> OrderNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> postNotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST));
    }


}
