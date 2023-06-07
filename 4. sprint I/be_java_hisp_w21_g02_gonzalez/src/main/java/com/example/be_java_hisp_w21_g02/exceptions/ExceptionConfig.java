package com.example.be_java_hisp_w21_g02.exceptions;

import com.example.be_java_hisp_w21_g02.dto.response.GenericResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.inidvidual.PromoBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.inidvidual.UserNotFoundToAddException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(UserNotSellerException.class)
    public ResponseEntity<?> userNotSellerException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(UserFollowingException.class)
    public ResponseEntity<?> UserFollowingException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(PostBadRequestException.class)
    public ResponseEntity<?> PostBadRequestException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> OrderNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    //INDIVIDUAL US0010
    @ExceptionHandler(PromoBadRequestException.class)
    public ResponseEntity<?> PromoBadRequestException(Exception e) {
        GenericResponseDTO genericResponseDTO = new GenericResponseDTO(400, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponseDTO);
    }

    @ExceptionHandler(UserNotFoundToAddException.class)
    public ResponseEntity<?> UserNotFoundToAddException(Exception e) {
        GenericResponseDTO genericResponseDTO = new GenericResponseDTO(404, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(genericResponseDTO);
    }
}