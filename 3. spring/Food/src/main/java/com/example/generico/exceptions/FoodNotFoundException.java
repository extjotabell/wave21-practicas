package com.example.generico.exceptions;

public class FoodNotFoundException extends RuntimeException {
  public FoodNotFoundException(String msg) {
    super(msg);
  }
}
