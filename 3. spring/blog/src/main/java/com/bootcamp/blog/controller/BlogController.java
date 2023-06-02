package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.service.ServicesBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @Autowired
    ServicesBlog service;


    @PostMapping("/Blog")
    public ResponseEntity<?> crearBlog(@RequestBody  BlogDTO blogDTO){
        service.crear(blogDTO);
    return ResponseEntity.status(HttpStatus.OK).body("El blog con id " + blogDTO.getId() + "fue creado con exito");
    }



}
