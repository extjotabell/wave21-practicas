package com.example.generico.exceptions;

import com.example.generico.DTO.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
  @ExceptionHandler(FoodNotFoundException.class)
  public ResponseEntity<ErrorDto> handlerFood(FoodNotFoundException e) {
    ErrorDto error = new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(IngredientNotFoundException.class)
  public ResponseEntity<ErrorDto> handlerIngredient(FoodNotFoundException e) {
    ErrorDto error = new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

}
