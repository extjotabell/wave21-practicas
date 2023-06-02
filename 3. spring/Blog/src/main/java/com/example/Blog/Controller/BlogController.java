package com.example.Blog.Controller;

import com.example.Blog.DTO.EntradaBlogDTO;
import com.example.Blog.DTO.ResponseDto;
import com.example.Blog.Service.EntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    EntradaBlogService entradaBlogService;
    @PostMapping
    public ResponseEntity<ResponseDto> postBlog(@RequestBody EntradaBlogDTO entrada){
        return entradaBlogService.saveBlog(entrada);
    }
}
