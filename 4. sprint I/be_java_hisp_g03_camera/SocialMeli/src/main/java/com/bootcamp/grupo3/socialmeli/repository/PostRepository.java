package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.PromoPost;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Repository
public class PostRepository implements IPostRepository {
    private final List<Post> posts = new ArrayList<>();
    private final Map<Integer,Double> discounts = new HashMap<>();
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
    public int getPromotionsFromUser(int userId) {
        return (int)getAllPostIdsFromUser(userId)
                .filter(discounts::containsKey)
                .count();
    }
    private IntStream getAllPostIdsFromUser(int userId){
        return posts.stream()
                .filter(p -> p.getUserId() == userId)
                .mapToInt(Post::getId);
    }

    @Override
    public void addPromotion(int postId, double discount) {
        discounts.put(postId, discount);
    }
}
