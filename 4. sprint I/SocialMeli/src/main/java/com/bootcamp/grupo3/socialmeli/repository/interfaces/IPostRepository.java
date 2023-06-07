package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PromoPostDTO;
import com.bootcamp.grupo3.socialmeli.model.Post;

import java.util.List;


public interface IPostRepository {

    int createPost(Post body);
    List<Post> getPostsByUserInTwoWeeks(int userId);

    int createPromoPost(Post body);

    long getCountPromoPostByUser(int userId);
}
