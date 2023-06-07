package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PromoPostRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IProductsService {
    ResponseEntity<?> createPost(PostRequestDTO postRequestDTO);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId);

    ResponseEntity<?> listFollowingPosts2Weeks(int userId, String order);

    /**
     * @param promoPostRequestDTO DTO with the promo post data
     * @return 200 if the post is a promo (has has_promo and discount) and can be created.
     * If the data isn't valid returns 400.
     */
    ResponseEntity<?> createPost(PromoPostRequestDTO promoPostRequestDTO);

    /**
     * @param userId
     * @return 200 if the id is valid and a body with the user data and its post count.
     * If the data isn't valid returns 400.
     */
    ResponseEntity<?> countPromoPosts(int userId);

    /**
     * @param userId
     * @param postId
     * @return 200 if the ids are valids and the post can be removed.
     * If the data isn't valid returns 400.
     */
    ResponseEntity<?> removePost(int userId, int postId);
}
