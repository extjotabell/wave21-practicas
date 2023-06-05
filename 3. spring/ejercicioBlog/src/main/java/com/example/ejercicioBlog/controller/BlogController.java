package com.example.ejercicioBlog.controller;

import com.example.ejercicioBlog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog(@RequestBody BlogDTO blogDTO){
        return ResponseEntity.created();
    }
}
