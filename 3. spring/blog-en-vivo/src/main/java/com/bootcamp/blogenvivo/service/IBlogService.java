package com.bootcamp.blogenvivo.service;

import com.bootcamp.blogenvivo.dto.requestDTO.RequestBlogDTO;
import org.springframework.http.ResponseEntity;

public interface IBlogService{

    ResponseEntity<?> insertBlog(RequestBlogDTO requestBlogDTO);

    ResponseEntity<?> getBlogById(int id);

    ResponseEntity<?> getAllBlogs();
}