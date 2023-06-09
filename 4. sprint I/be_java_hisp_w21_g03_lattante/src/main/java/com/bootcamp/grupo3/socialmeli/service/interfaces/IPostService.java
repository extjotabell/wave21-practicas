package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PostOnSaleDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostOnSaleUserDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PromoCountDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;


public interface IPostService {
    int createPost(PostDTO body);
    UserPostListDTO getPostList(int userId, String order);

    MessageDTO createPostOnSale(PostOnSaleDTO postOnSaleDTO);

    PromoCountDTO countProductsOnSale(int userId);

    PostOnSaleUserDTO getPromoPostByUserId(int userId,String order);
}
