package com.blog.blog.controller;

import com.blog.blog.dto.BlogDTO;
import com.blog.blog.exception.EntradaBlogExisteException;
import com.blog.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> crearBlog(@RequestBody BlogDTO blogDTO) throws EntradaBlogExisteException {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.crear(blogDTO));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> buscarBlog(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(blogService.buscarPorId(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> encontrarBlogs(){
        return ResponseEntity.ok(blogService.buscarTodos());
    }
}
