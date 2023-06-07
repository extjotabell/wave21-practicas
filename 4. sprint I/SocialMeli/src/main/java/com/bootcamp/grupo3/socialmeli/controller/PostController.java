package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostDiscountCountByUserDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostListDTO;
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

    @PostMapping("/promo-post")
    public ResponseEntity<MessageDTO> createPromoPost(@RequestBody PostDTO body) {
        int postId = postService.createPost(body);
        return ResponseEntity.ok(new MessageDTO("Post Con Descuento agregado exitosamente con id: " + postId));
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<PostDiscountCountByUserDTO> getPostDiscountCountByUser( @RequestParam(value = "user_id", required = true) int userId){
        PostDiscountCountByUserDTO response = postService.getPostsDiscountByUser(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostListDTO> listPostOfFollowers(@PathVariable final int userId, @RequestParam(required = false) final String order) {
        UserPostListDTO posts = postService.getPostList(userId, order);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PostListDTO> getPostWithDiscount(@RequestParam(required = true) int userId ){
        PostListDTO hasDiscountList = postService.getPostListHasDiscount(userId);
        return new ResponseEntity<>(hasDiscountList, HttpStatus.OK);
    }
}
