package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PromoPostRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IProductsService {
    ResponseEntity<?> createPost(PostRequestDTO postRequestDTO);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId, String order);

    ResponseEntity<?> createPromoPost(PromoPostRequestDTO promoPostRequestDTO);

    ResponseEntity<?> promoPostCountBySeller(int userId);
}
