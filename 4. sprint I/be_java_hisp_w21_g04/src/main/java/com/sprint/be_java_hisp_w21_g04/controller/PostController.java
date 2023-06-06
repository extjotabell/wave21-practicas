package com.sprint.be_java_hisp_w21_g04.controller;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.service.post.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {
    private IPostService _service;

    public PostController(IPostService service){
        this._service = service;
    }

    @PostMapping("/post")
    public ResponseEntity<Void> post(@RequestBody(required = true) PostRequestDto post) {
        this._service.post(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//
//    @GetMapping("/followed/{userId}/list")
//    public ResponseEntity<SellerFollowedListPostResponseDto> sellerFollowedListPosts(@PathVariable int userId){
//        return new ResponseEntity<>(this._service.sellerFollowedListPosts(userId), HttpStatus.OK);
//    }

//    Se sobrecarga el metodo con los query params con (@RequestParam String order)
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerFollowedListPostResponseDto> sellerFollowedListPosts(@PathVariable int userId, @RequestParam(required = false, value = "order", defaultValue = "date_asc") String order){
        return new ResponseEntity<>(this._service.sellerFollowedListPosts(userId, order), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PostResponseDto>> getAll(){
        return new ResponseEntity<>(this._service.getAll(), HttpStatus.OK);
    }
}
