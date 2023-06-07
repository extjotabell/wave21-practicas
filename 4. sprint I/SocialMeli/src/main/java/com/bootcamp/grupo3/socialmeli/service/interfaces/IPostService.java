package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PromotionPostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPromoPostCountDTO;


public interface IPostService {
    int createPost(PostDTO body);
    int createPromotionPost(PromotionPostDTO postDTO);
    UserPostListDTO getPostList(int userId, String order);
    UserPromoPostCountDTO getListOfPromotionPost(int userId);
}
