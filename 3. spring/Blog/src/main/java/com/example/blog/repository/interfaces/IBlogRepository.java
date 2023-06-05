package com.example.blog.repository.interfaces;

import com.example.blog.model.Blog;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IBlogRepository {
    void create(Blog blog);
    Optional<Blog> getBlogById(Integer id);
}
