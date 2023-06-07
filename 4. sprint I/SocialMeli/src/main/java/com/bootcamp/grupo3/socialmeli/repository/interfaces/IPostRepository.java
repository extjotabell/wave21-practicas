package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.PostOnSale;

import java.util.List;


public interface IPostRepository {

    int createPost(Post body);
    List<Post> getPostsByUserInTwoWeeks(int userId);

    int createPostOnSale(PostOnSale newPost);

    List<PostOnSale> getPostsOnSaleByUserId(int userId);
}
