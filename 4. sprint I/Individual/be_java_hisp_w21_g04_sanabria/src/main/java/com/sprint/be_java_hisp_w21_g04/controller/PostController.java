package com.sprint.be_java_hisp_w21_g04.controller;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostProductOnSaleRequestDto;
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
    public ResponseEntity<ResponseDto> postProductOnSale(@RequestBody(required = true) PostProductOnSaleRequestDto post) {
        return new ResponseEntity<>(this._service.postProductOnSale(post),HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostProductOnSaleCountDto> countPromoPost(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(this._service.countPromoPost(userId), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<ListProductsOnSaleResponseDto> listProductsOnSale(@RequestParam("user_id") int userId, @RequestParam(required = false, value = "order", defaultValue = "date_asc") String order){
        return new ResponseEntity<>(this._service.listProductsOnSaleSorted(userId, order), HttpStatus.OK);
    }
}
