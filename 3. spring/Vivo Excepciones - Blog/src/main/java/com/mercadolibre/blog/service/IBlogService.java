package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.requestDTO.RequestBlogDTO;
import org.springframework.http.ResponseEntity;

public interface IBlogService{

    ResponseEntity<?> insertBlog(RequestBlogDTO requestBlogDTO);

    ResponseEntity<?> getBlogById(int id);

    ResponseEntity<?> getAllBlogs();
}
