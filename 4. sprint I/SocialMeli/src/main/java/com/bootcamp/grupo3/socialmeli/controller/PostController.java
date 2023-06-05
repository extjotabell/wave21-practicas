package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private IPostService postService;

    public PostController(IPostService postService){
        this.postService = postService;
    }
}
