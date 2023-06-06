package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private int getNextId(){
        return ++nextId;
    }
}
