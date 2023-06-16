package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IProductsService {
    /**
     * @param postRequestDTO DTO with the information of the post to be created
     * @return A response entity with the status of the request
     */
    ResponseEntity<?> createPost(PostRequestDTO postRequestDTO);

    /**
     * @param userId the id of the user that wants to know the posts of the last 2 weeks of the users that he follows
     * @return A response entity with the status of the request and body with the list of posts ordered by date in descending order
     */
    ResponseEntity<?> listFollowingPosts2Weeks(int userId);

    /**
     * @param userId the id of the user that wants to know the posts of the last 2 weeks of the users that he follows
     * @param order parameter to order the list by date in ascending or descending order
     * @return A response entity with the status of the request and body with the list of posts ordered by date
     */
    ResponseEntity<?> listFollowingPosts2Weeks(int userId, String order);
}
