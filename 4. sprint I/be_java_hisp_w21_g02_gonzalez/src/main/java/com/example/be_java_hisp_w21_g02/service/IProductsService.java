package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.request.ProductWithPromoRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IProductsService {
    ResponseEntity<?> createPost(PostRequestDTO postRequestDTO);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId, String order);

    //INDIVIDUAL US0010
    ResponseEntity<?> createProductWithPromo(ProductWithPromoRequestDTO productDTO);

    //INDIVIDUAL US0011
    ResponseEntity<?> getProductsWithPromoByUserId(int userId);
}