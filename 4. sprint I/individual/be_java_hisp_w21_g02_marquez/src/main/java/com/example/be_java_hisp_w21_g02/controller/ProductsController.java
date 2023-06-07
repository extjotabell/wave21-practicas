package com.example.be_java_hisp_w21_g02.controller;

import com.example.be_java_hisp_w21_g02.dto.request.PostPromoDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
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

    @GetMapping("/list")
    public ResponseEntity<?> getListProductsFilterByPrice(@RequestParam String filter,
                                                          @RequestParam("minimum_price") double minimumPrice,
                                                       @RequestParam("maximum_price") double maximumPrice) {
        if (!Constants.isOrderConstant(filter))
            throw new OrderNotFoundException("El tipo de filtrado no existe");

        return _productsService.getListProductsFilterByPrice(minimumPrice, maximumPrice);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PostPromoDTO postPromoDTO){
        _productsService.createPromoPost(postPromoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(
                _productsService.getPromoPostCount(userId), HttpStatus.OK
        );
    }
}
