package com.example.be_java_hisp_w21_g02.controller;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.service.IProductsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Validated
public class ProductsController {

    private final IProductsService _productsService;

    public ProductsController(IProductsService productsService) {
        this._productsService = productsService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody @Valid PostRequestDTO postRequestDTO){
        return _productsService.createPost(postRequestDTO);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> listFollowingPosts2Weeks(@PathVariable
                                                          @Positive(message = "User ID to follow must be greater than zero")
                                                          Integer userId,
                                                      @RequestParam(required = false)
                                                      String order){
        return _productsService.listFollowingPosts2Weeks(userId, order);
    }
}
