package com.example.demo.controller;

import com.example.demo.DTO.RequestBlogDTO;
import com.example.demo.Service.EntradaBlogService;
import com.example.demo.model.EntradaBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntradaBlogController {
    @Autowired
    private EntradaBlogService entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlog> postBlog(@RequestBody RequestBlogDTO entrada){
        return ResponseEntity.ok(entradaBlogService.saveBlog(entrada));
    }
}
