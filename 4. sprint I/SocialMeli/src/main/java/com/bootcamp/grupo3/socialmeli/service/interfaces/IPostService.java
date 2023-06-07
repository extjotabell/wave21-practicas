package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PostWithPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.ListPostWithPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostWithPromo;


public interface IPostService {
    int createPost(PostDTO body);
    UserPostListDTO getPostList(int userId, String order);
    //Individuales
    int createPostWithPromo(PostWithPromoDTO body);
    UserPostWithPromo getPostWithPromoByUser(final int userId);
    ListPostWithPromoDTO getPostListWithPromo(final int userId, final String order);
}
