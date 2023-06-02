package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface ServicesBlog {

    public long crear(BlogDTO blog);
    public List<BlogDTO> buscarTodos();
}
