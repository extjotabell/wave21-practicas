package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PromotionPostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.TrendingPostsDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPromoPostCountDTO;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
public class PostController {
    private final IPostService postService;

    public PostController(IPostService postService){
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

    @PutMapping("/post/{userId}/like/{postId}")
    public ResponseEntity<MessageDTO> like(@PathVariable int userId,
                                             @PathVariable int postId){
        return ResponseEntity.ok(postService.like(userId, postId));
    }

    @PutMapping("/post/{userId}/unlike/{postId}")
    public ResponseEntity<MessageDTO> unlike(@PathVariable int userId,
                                           @PathVariable int postId){
        return ResponseEntity.ok(postService.unlike(userId, postId));
    }

    @GetMapping("/post/trending/{amount}")
    public ResponseEntity<TrendingPostsDTO> getTrendingPosts(@PathVariable int amount,
                                                             @RequestParam(value = "order", required = false) String order){
        return ResponseEntity.ok(postService.getTrendingPosts(amount, order));
    }
}
