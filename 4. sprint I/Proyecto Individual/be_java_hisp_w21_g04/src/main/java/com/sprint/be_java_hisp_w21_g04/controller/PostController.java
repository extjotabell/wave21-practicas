package com.sprint.be_java_hisp_w21_g04.controller;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestPromoDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
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
    public ResponseEntity<String> post(@RequestBody(required = true) PostRequestDto post) {
        this._service.post(post);
        return new ResponseEntity<>("Post agregado exitosamente",HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerFollowedListPostResponseDto> sellerFollowedListPosts(@PathVariable int userId, @RequestParam(required = false, value = "order", defaultValue = "date_asc") String order){
        return new ResponseEntity<>(this._service.sellerFollowedListPosts(userId, order), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PostResponseDto>> getAll(){
        return new ResponseEntity<>(this._service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDto> promoPost(@RequestBody(required = true) PostRequestPromoDto post) {
        this._service.promoPost(post);
        return new ResponseEntity<>(new ResponseDto("Promo-post agregado correctamente"),HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoCountDto> promoPostCount(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(this._service.promoPostCount(userId),HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoListDto> promoPostList(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(this._service.promoList(userId),HttpStatus.OK);
    }

}
