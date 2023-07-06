package com.example.demo.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class TestNotFoundException extends RuntimeException {
  public TestNotFoundException() {
    super();
  }
}
