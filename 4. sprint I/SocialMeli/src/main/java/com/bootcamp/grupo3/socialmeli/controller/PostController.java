package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Optional;

@RestController
public class PostController {
    private IPostService postService;

    public PostController(IPostService postService, IUserService userService){
        this.postService = postService;
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<UserPostListDTO> listPostOfFollowers(@PathVariable final int userId, @RequestParam(required = false) final String order) {
        UserPostListDTO posts = postService.getPostList(userId, order);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
