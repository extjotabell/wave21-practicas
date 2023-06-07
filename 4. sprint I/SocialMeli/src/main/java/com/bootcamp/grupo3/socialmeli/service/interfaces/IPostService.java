package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PromoPostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPromoPostCountDTO;


public interface IPostService {
    int createPost(PostDTO body);
    UserPostListDTO getPostList(int userId, String order);

    int createPromoPost(PromoPostDTO body);

    UserPromoPostCountDTO getUserPromoPostCount(final int id);
}
