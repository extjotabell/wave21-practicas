package com.example.Blog.dto;

import org.springframework.http.HttpStatus;

public record ErrorDTO ( String reason, HttpStatus status){}
