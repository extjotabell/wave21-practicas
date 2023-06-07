package com.example.be_java_hisp_w21_g02.controller;

import com.example.be_java_hisp_w21_g02.dto.request.CreatePromoPostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.PromoPostCountDto;
import com.example.be_java_hisp_w21_g02.exceptions.OrderNotFoundException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.service.IProductsService;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    IProductsService productsService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO postRequestDTO){
        return productsService.createPost(postRequestDTO);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> listFollowingPosts2Weeks(@PathVariable int userId, @RequestParam(required = false) String order){
        if (order != null && !Constants.isOrderConstant(order))
            throw new OrderNotFoundException("El tipo de ordenamiento no existe");

        ResponseEntity<?> result = new ResponseEntity<>(HttpStatus.OK);

        if (order != null)
            result =  productsService.listFollowingPosts2Weeks(userId, order);
        else
            result =  productsService.listFollowingPosts2Weeks(userId);


        return result;
    }

    // ? US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody CreatePromoPostDTO createPromoPostDTO){
        productsService.createPromoPost(createPromoPostDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // ? US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam("user_id") int userId){
        PromoPostCountDto promoPostCountDto = productsService.getPromoPostCount(userId);
        return new ResponseEntity<>(promoPostCountDto,null,HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    // ? BONUS
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Post> allPosts = productsService.getAllPosts();
        return new ResponseEntity<>(allPosts,null,HttpStatus.OK);
    }
}
