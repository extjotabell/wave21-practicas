package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog getById(Integer id);
    List<Blog> getAll();
    Blog insertBlog(Blog blog);
}