package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.Product;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository {
    private final List<Post> posts = new ArrayList<>();

    public List<Post> getPostsByUserInTwoWeeks(int userId) {
        LocalDate pastTwoWeek = LocalDate.now().minusWeeks(2);

        return posts.stream()
          .filter(p -> p.getUserId() == userId)
          .filter(post -> post.getDate().isAfter(pastTwoWeek))
          .toList();
    }
}
