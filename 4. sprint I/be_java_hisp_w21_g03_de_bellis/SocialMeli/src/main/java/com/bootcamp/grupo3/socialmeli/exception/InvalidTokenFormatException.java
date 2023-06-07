package com.bootcamp.grupo3.socialmeli.exception;

public class InvalidTokenFormatException extends RuntimeException {
  public InvalidTokenFormatException(String msg) {
    super(msg);
  }
}
