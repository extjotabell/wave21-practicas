package com.example.demo.service;

import com.example.demo.dto.BlogDTO;
import com.example.demo.dto.BlogIDDTO;
import com.example.demo.dto.BlogResponseDTO;

import java.util.List;

public interface IBlogService {

    List<BlogResponseDTO> getAllBlogs();
    BlogResponseDTO getBlog(Integer id);
    BlogIDDTO createBlog(BlogDTO blogDTO);
}