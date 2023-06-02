package com.practicaSpring.ejercicioBlog.repositories;

import com.practicaSpring.ejercicioBlog.entities.Blog;

import java.util.List;
import java.util.UUID;

public interface IBlogRepository {
    UUID createBlog(Blog blog);
    Blog getById(UUID id);
    List<Blog> getAll();
}
