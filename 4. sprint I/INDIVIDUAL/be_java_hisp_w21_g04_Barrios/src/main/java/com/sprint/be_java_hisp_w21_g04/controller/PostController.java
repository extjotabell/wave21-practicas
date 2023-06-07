package com.sprint.be_java_hisp_w21_g04.controller;

import com.sprint.be_java_hisp_w21_g04.dto.request.PromoPostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.service.post.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService _service;

    public PostController(IPostService service) {
        this._service = service;
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDto> post(@RequestBody(required = true) PostRequestDto post) {
        return ResponseEntity.ok(_service.post(post));

    }

    @PostMapping("/promo-post")
    public ResponseEntity<ResponseDto> post(@RequestBody(required = true) PromoPostRequestDto promoPost) {
        return ResponseEntity.ok(_service.post(promoPost));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellerFollowedListPostResponseDto> sellerFollowedListPosts(@PathVariable int userId,
                                                                                     @RequestParam(required = false, value = "order",
                                                                                                   defaultValue = "date_asc") String order) {
        return new ResponseEntity<>(this._service.sellerFollowedListPosts(userId, order), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PostResponseDto>> getAll() {
        return new ResponseEntity<>(this._service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountProductsDto> getPromoPostCountProducts(@RequestParam(value = "user_id") int userId) {
        return new ResponseEntity<>(this._service.getPromoPostCountProducts(userId), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<ProdPromoPostResponseDto>  getPromoPostList(@RequestParam(value = "user_id") int userId){
        return new ResponseEntity<>(this._service.getPromoPostList(userId), HttpStatus.OK);
    }
}
