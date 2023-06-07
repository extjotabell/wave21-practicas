package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private final List<Post> posts = new ArrayList<>();
    private int nextId;

    public PostRepository() {
        this.nextId = 0;
    }

    @Override
    public int createPost(Post body) {
        body.setId(getNextId());
        posts.add(body);
        return body.getId();
    }

    private int getNextId() {
        return ++nextId;
    }

    public List<Post> getPostsByUserInTwoWeeks(int userId) {
        LocalDate pastTwoWeek = LocalDate.now().minusWeeks(2);

        return posts.stream()
          .filter(p -> p.getUserId() == userId)
          .filter(post -> post.getDate().isAfter(pastTwoWeek))
          .toList();
    }

    @Override
    public List<Post> getPromotionPost(int userId) {
        return posts
                .stream()
                .filter(post -> post.getUserId() == userId && post.isHasPromo())
                .collect(Collectors.toList());
    }
}
