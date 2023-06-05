package com.example.Blog.controller;

import com.example.Blog.dto.BlogDTO;
import com.example.Blog.dto.BlogIDDTO;
import com.example.Blog.dto.BlogResponseDTO;
import com.example.Blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogResponseDTO>> getAllBlogs() {
        List<BlogResponseDTO> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogResponseDTO> getBlog(@PathVariable final Integer id) {
        BlogResponseDTO blog = blogService.getBlog(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<BlogIDDTO> createBlog(@RequestBody final BlogDTO blog){
        BlogIDDTO blogId = blogService.createBlog(blog);
        return new ResponseEntity<>(blogId, HttpStatus.OK);
    }
}
