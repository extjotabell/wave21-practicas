package com.bootcamp.grupo3.socialmeli.exception;

public class BadPasswordException extends RuntimeException {
  public BadPasswordException(String msg) {
    super(msg);
  }
}
