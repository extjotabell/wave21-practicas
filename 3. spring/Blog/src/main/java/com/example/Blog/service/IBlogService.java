package com.example.Blog.service;

import com.example.Blog.dto.BlogDTO;
import com.example.Blog.dto.BlogIDDTO;
import com.example.Blog.dto.BlogResponseDTO;

import java.util.List;

public interface IBlogService {

    List<BlogResponseDTO> getAllBlogs();
    BlogResponseDTO getBlog(Integer id);
    BlogIDDTO createBlog(BlogDTO blogDTO);
}
