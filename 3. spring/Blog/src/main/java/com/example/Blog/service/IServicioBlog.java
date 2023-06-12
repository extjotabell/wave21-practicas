package com.example.Blog.service;

import com.example.Blog.dto.request.PostBlogDTO;
import com.example.Blog.dto.response.EntradaDTO;

import java.util.List;

public interface IServicioBlog {
    void createBlog(PostBlogDTO postBlogDto);
    EntradaDTO retornarBlog(int id);
    List<EntradaDTO> retornarTodosLosBlogs();
}
