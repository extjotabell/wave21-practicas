package com.example.blog.services;

import com.example.blog.dto.request.BlogRequestDto;
import com.example.blog.dto.response.BlogResponseDto;

import java.util.List;
import java.util.UUID;

public interface IBlogService {

    UUID createBlog(BlogRequestDto blogDto);
    BlogResponseDto getById(UUID id);
    List<BlogResponseDto> getAll();

}
