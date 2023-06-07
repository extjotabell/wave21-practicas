package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PromotionPostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPromoPostCountDTO;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
public class PostController {
    private IPostService postService;

    public PostController(IPostService postService, IUserService userService){
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<MessageDTO> createPost(@RequestBody PostDTO body) {
        int postId = postService.createPost(body);
        return ResponseEntity.ok(new MessageDTO("Post agregado exitosamente con id: " + postId));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostListDTO> listPostOfFollowers(@PathVariable final int userId, @RequestParam(required = false) final String order) {
        UserPostListDTO posts = postService.getPostList(userId, order);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<MessageDTO> createPromotionPost(@RequestBody PromotionPostDTO post){
        return ResponseEntity.ok(new MessageDTO("Post con producto en promoción agregado exitosamente con id: " + postService.createPromotionPost(post)));
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<UserPromoPostCountDTO> listOfPromotionPost(@RequestParam (value = "user_id") int userId){
        return ResponseEntity.ok(postService.getListOfPromotionPost(userId));
    }
}
