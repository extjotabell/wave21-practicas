package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.model.Post;

import java.util.List;

public interface IPostRepository {
  public List<Post> getPostsByUserInTwoWeeks(int userId);
}
