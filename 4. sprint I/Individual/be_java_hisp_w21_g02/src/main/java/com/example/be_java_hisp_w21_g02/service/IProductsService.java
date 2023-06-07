package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestPromoDTO;
import com.example.be_java_hisp_w21_g02.dto.response.CountPromoPostDTO;
import org.springframework.http.ResponseEntity;

public interface IProductsService {
    ResponseEntity<?> createPost(PostRequestDTO postRequestDTO);

    ResponseEntity<?> createPostPromo(PostRequestPromoDTO postRequestDTO);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId, String order);
    CountPromoPostDTO getPromoList(int userId);
}
