package com.example.generico.exceptions;

public class IngredientNotFoundException extends RuntimeException {
  public IngredientNotFoundException(String msg) {
    super(msg);
  }
}
