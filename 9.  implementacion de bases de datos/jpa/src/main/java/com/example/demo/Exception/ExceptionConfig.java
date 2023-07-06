package com.example.demo.Exception;

import com.example.demo.dto.ErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDTO> handler(MethodArgumentNotValidException e) {
    return ResponseEntity.badRequest().body(
      new ErrorDTO(
        "Found some errors:",
        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList()
      )
    );
  }
}
