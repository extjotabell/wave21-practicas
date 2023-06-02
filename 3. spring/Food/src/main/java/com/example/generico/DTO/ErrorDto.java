package com.example.generico.DTO;

import org.springframework.http.HttpStatus;

public record ErrorDto (String msg, HttpStatus status) {
}
