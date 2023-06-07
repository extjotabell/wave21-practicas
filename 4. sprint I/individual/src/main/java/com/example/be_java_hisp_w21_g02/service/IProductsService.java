package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.request.CreatePromoPostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.PromoPostCountDto;
import com.example.be_java_hisp_w21_g02.model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductsService {
    ResponseEntity<?> createPost(PostRequestDTO postRequestDTO);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId, String order);

    // ? US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    void createPromoPost(CreatePromoPostDTO createPromoPostDTO);

    List<Post> getAllPosts();

    PromoPostCountDto getPromoPostCount(int userId);
}
