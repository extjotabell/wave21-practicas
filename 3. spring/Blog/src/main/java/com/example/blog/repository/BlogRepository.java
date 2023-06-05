package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.repository.interfaces.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {
    private List<Blog> blogs = new ArrayList<>();
    @Override
    public void create(Blog blog) {
        blogs.add(blog);
    }

    @Override
    public Optional<Blog> getBlogById(Integer id) {
        return blogs.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst();
    }
}
