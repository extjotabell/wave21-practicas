package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PostPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostIdPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostPromoMetricDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.order.PostOrderType;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostPromoService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PostController {
    private IPostService postService;
    private IPostPromoService postPromoService;

    public PostController(IPostService postService, IPostPromoService postPromoService ) {
        this.postService = postService;
        this.postPromoService = postPromoService;
    }

    @GetMapping("/promo-post/count/{token}")
    public ResponseEntity<PostPromoMetricDTO> createPropoPost(
      @PathVariable final String token
    ) throws UserPermissionException {

      PostPromoMetricDTO promo = postPromoService.getMetricPostPromo(token);

      return new ResponseEntity<>(promo, HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostIdPromoDTO> createPromoPost(
      @RequestBody final PostPromoDTO pDto
    ) throws UserPermissionException {

      PostIdPromoDTO promo = postPromoService.createPostPromo(pDto);

      return new ResponseEntity<>(promo, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<MessageDTO> createPost(
      @RequestBody PostDTO body
    ) throws UserPermissionException {
        int postId = postService.createPost(body);
        return ResponseEntity.ok(new MessageDTO("Post agregado exitosamente con id: " + postId));
    }

    @GetMapping("/followed/{token}/list")
    public ResponseEntity<UserPostListDTO> listPostOfFollowers(
      @PathVariable final String token,
      @RequestParam Optional<String> order
    ) throws UserPermissionException {

        PostOrderType orderEnum = order
          .map(PostOrderType::getEnumValue)
          .orElse(PostOrderType.DEFAULT);

        UserPostListDTO posts = postService.getPostList(token, orderEnum);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
