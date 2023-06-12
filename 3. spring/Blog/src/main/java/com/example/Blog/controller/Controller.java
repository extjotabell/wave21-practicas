package com.example.Blog.controller;

import com.example.Blog.dto.request.PostBlogDTO;
import com.example.Blog.dto.response.EntradaDTO;
import com.example.Blog.service.ServicioBlog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    ServicioBlog servicio;

    public Controller(ServicioBlog servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog (@RequestBody PostBlogDTO postBlogDTO)
    {
        servicio.createBlog(postBlogDTO);
        return new ResponseEntity<>("Se ha creado el blog!", HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaDTO> returnBlog (@PathVariable int id)
    {
        return new ResponseEntity<>(servicio.retornarBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaDTO>> returnAllBlogs()
    {
        return new ResponseEntity<>(servicio.retornarTodosLosBlogs(), HttpStatus.OK);
    }
}
