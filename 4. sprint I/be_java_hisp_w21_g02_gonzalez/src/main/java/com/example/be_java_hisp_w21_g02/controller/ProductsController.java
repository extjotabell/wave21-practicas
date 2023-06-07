package com.example.be_java_hisp_w21_g02.controller;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.request.ProductWithPromoRequestDTO;
import com.example.be_java_hisp_w21_g02.exceptions.OrderNotFoundException;
import com.example.be_java_hisp_w21_g02.service.IProductsService;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    IProductsService _productsService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO postRequestDTO){
        return _productsService.createPost(postRequestDTO);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> listFollowingPosts2Weeks(@PathVariable int userId, @RequestParam(required = false) String order){
        if (order != null && !Constants.isOrderConstant(order))
            throw new OrderNotFoundException("El tipo de ordenamiento no existe");

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.OK);

        if (order != null)
            result =  _productsService.listFollowingPosts2Weeks(userId, order);
        else
            result =  _productsService.listFollowingPosts2Weeks(userId);


        return result;
    }

    //INDIVIDUAL US0010
    @PostMapping("/promo-post")
    public ResponseEntity<?> createProductWithPromo(@RequestBody ProductWithPromoRequestDTO productDTO){
        return _productsService.createProductWithPromo(productDTO);
    }

    //INDIVIDUAL US0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getProductsWithPromoByUserId(@RequestParam int user_id){
        return _productsService.getProductsWithPromoByUserId(user_id);
    }
}