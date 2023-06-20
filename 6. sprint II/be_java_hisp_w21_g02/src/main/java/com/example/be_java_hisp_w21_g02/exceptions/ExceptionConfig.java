package com.example.be_java_hisp_w21_g02.exceptions;

import com.example.be_java_hisp_w21_g02.dto.response.ErrorDTO;
import com.example.be_java_hisp_w21_g02.dto.response.ExceptionDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionConfig.class);

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> validationException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(
                new ExceptionDTO("The following errors were found in the validations:",
                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList())
                )
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDTO> validationException(ConstraintViolationException e){
        return ResponseEntity.badRequest().body(
                new ExceptionDTO("The following errors were found in the validations:",
                        e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
                )
        );
    }
}
