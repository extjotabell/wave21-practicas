package com.example.blog.repositories;

import com.example.blog.entities.Blog;
import com.example.blog.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BlogRepository implements IBlogRepository{
    private List<Blog> blogs;

    public BlogRepository(){
        this.blogs = new ArrayList<>();
    }

    @Override
    public UUID createBlog(Blog blog) {
        this.blogs.add(blog);
        return blog.getId();
    }

    @Override
    public Blog getById(UUID id) {
        return this.blogs.stream().filter(blog -> blog.getId().equals(id)).findFirst().orElseThrow(() -> new NotFoundException("Blog no encontrado"));
    }

    @Override
    public List<Blog> getAll() {
        return this.blogs;
    }
}
