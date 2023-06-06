package com.example.be_java_hisp_w21_g02.controller;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    IProductsService productsService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO postRequestDTO){
        return productsService.createPost(postRequestDTO);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> listFollowingPosts2Weeks(@PathVariable int userId){
        return productsService.listFollowingPosts2Weeks(userId);
    }
}
