package com.example.generico.Exceptions;

public class InternalErrorException extends RuntimeException {
  public InternalErrorException(String msj) {
    super(msj);
  }
  public InternalErrorException() {
    super();
  }
}
