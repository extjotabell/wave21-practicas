package com.bootcamp.blogenvivo.repository;


import com.bootcamp.blogenvivo.model.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog getById(Integer id);
    List<Blog> getAll();
    Blog insertBlog(Blog blog);
}