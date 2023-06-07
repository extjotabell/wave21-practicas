package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PromoPostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PromoPostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PromoProductsCountDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;


public interface IPostService {
    int createPost(PostDTO body);
    UserPostListDTO getPostList(int userId, String order);
    int createPromoPost(PromoPostDTO body);
    PromoProductsCountDTO getPromoProductCount(int userId);

    PromoPostListDTO getPromoPostList(int userId, String order);
}
