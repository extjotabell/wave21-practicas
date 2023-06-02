package com.bootcamp.blog.repository;


import com.bootcamp.blog.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface RepositoryBlog {

    public long crear(Blog blog);
    public Optional<Blog> buscarBlogPorID(Long id);
    public List<Blog> buscarTodos();


}
