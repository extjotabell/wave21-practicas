package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import com.example.blog.service.interfaces.IBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.function.EntityResponse;

@Controller
public class BlogController {
    private IBlogService blogService;

    public BlogController(IBlogService blogService){
        this.blogService = blogService;
    }
    @PostMapping("blog")
    public ResponseEntity<BlogDTO> create(@RequestBody BlogDTO blog){
        return ResponseEntity.of(blogService.create(blog))
    }

}
