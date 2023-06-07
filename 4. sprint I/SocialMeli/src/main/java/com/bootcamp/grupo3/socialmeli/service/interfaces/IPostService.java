package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostDiscountCountByUserDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.model.Post;

import java.util.List;


public interface IPostService {
    int createPost(PostDTO body);
    UserPostListDTO getPostList(int userId, String order);

    PostDiscountCountByUserDTO getPostsDiscountByUser(int userId);


    PostListDTO getPostListHasDiscount(int userId);
}
