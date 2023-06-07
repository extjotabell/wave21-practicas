package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PromoRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g02.dto.response.PromoCountDTO;
import org.springframework.http.ResponseEntity;

public interface IProductsService {
    ResponseEntity<?> createPost(PostRequestDTO postRequestDTO);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId, String order);

    ResponseEntity<?> createPostHasPromo(PromoRequestDTO promoRequestDto);

    PromoCountDTO getPostCount(int userId);
}
