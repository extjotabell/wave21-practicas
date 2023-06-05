package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.service.ServicesBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    @Autowired
    ServicesBlog service;


    @PostMapping("/blog/create")
    public ResponseEntity<?> crearBlog(@RequestBody  BlogDTO blogDTO){
        service.crear(blogDTO);
    return ResponseEntity.status(HttpStatus.OK).body("El blog con id " + blogDTO.getId() + "fue creado con exito");
    }

    @GetMapping("/allBlogs")
    public ResponseEntity<?> traerTodosLosBlogs(){

        return ResponseEntity.status(HttpStatus.OK).body(this.service.buscarTodos());
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> traerBlogPorID(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(this.service.buscarBlogPorID(id));
    }


}
