package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PromoPostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PromoPostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PromoProductsCountDTO;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.springframework.http.HttpStatus;

import java.util.List;

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

    //Individual
    @PostMapping("/promo-post")
    public ResponseEntity<MessageDTO> createPromoPost(@RequestBody PromoPostDTO body) {
        int postId = postService.createPromoPost(body);
        return ResponseEntity.ok(new MessageDTO("Promo Post agregado exitosamente con id: " + postId));
    }


    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> countPromoProducts(@RequestParam int user_id ) {
        PromoProductsCountDTO productsCount = postService.getPromoProductCount(user_id);

        return new ResponseEntity<>(productsCount, HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListDTO> listPromoPost(@RequestParam int user_id, @RequestParam(required = false) final String order) {
        PromoPostListDTO promoPostList = postService.getPromoPostList(user_id, order);

        return new ResponseEntity<>(promoPostList, HttpStatus.OK);
    }
}
