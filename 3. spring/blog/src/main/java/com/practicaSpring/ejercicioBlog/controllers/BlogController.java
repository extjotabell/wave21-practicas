package com.practicaSpring.ejercicioBlog.controllers;

import com.practicaSpring.ejercicioBlog.dto.request.BlogRequestDto;
import com.practicaSpring.ejercicioBlog.dto.response.BlogResponseDto;
import com.practicaSpring.ejercicioBlog.services.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BlogController {

    private IBlogService _service;

    public BlogController(IBlogService service){
        this._service = service;
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogResponseDto> getBlogByID(@PathVariable String id) {
        return  new ResponseEntity<>(_service.getById(UUID.fromString(id)),HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogResponseDto>> getBlog() {
        return new ResponseEntity<>(_service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<UUID> createBlog(@RequestBody BlogRequestDto blogDto) {
        return new ResponseEntity<>(_service.createBlog(blogDto), HttpStatus.CREATED);
    }

}
