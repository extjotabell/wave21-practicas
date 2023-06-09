package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.model.Post;

import java.util.List;
import java.util.Optional;


public interface IPostRepository {

    int createPost(Post body);
    List<Post> getPostsByUserInTwoWeeks(int userId);
    Optional<Post> getPostById(int postId);
}
