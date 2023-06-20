package com.example.be_java_hisp_w21_g02.exceptions;

import com.example.be_java_hisp_w21_g02.dto.ErrL;
import com.example.be_java_hisp_w21_g02.dto.response.ErrorDTO;
import com.example.be_java_hisp_w21_g02.dto.response.ExceptionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrL handleConstraintViolationException(HttpServletRequest request, Exception ex) {
//        ErrL error = new ErrL();
//
//        error.setTimestamp(new Date());
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.addError(ex.getMessage());
//        error.setPath(request.getServletPath());
//
//        LOGGER.error(ex.getMessage(), ex);
//
//        return error;
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrL handleMethodArgumentNotValidException(HttpServletRequest request, Exception ex) {
//        ErrL error = new ErrL();
//
//        error.setTimestamp(new Date());
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.addError(ex.getMessage());
//        error.setPath(request.getServletPath());
//
//        LOGGER.error(ex.getMessage(), ex);
//
//        return error;
//    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
//        Map<String, String> errors = new HashMap<>();
//        errors.put("error", "An unexpected error occurred");
//
//        String exceptionType = ex.getClass().getName();
//        errors.put("exceptionType", exceptionType);
//
//        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ExceptionDTO> validationException(MethodArgumentNotValidException e){
//        return ResponseEntity.badRequest().body(
//                new ExceptionDTO("The following errors were found in the validations:",
//                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList())
//                )
//        );
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<ExceptionDTO> validationException(ConstraintViolationException e){
//        return ResponseEntity.badRequest().body(
//                new ExceptionDTO("The following errors were found in the validations:",
//                        e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
//                )
//        );
//    }
}
