package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PostWithPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.ListPostWithPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostWithPromo;
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

    //Individual
    @PostMapping("/promo-post")
    public ResponseEntity<MessageDTO> createPostWithPromo(@RequestBody PostWithPromoDTO body){
        int postId = postService.createPostWithPromo(body);
        return ResponseEntity.ok(new MessageDTO("Post con promociòn agregado exitosamente con id: " + postId));
    }

    //individual-US11
    @GetMapping("promo-post/count")
    public ResponseEntity<UserPostWithPromo> getPostWithPromoByUser(@RequestParam(value = "user_id" ) int userId){
        return ResponseEntity.ok(postService.getPostWithPromoByUser(userId));
    }

    //Individual-Bonus
    @GetMapping("promo-post/list")
    public ResponseEntity<ListPostWithPromoDTO> getPostWithPromos(@RequestParam(value = "userid") final int userId, @RequestParam(value="order",required = false) final String order) {

        return ResponseEntity.ok(postService.getPostListWithPromo(userId,order));
    }
}
