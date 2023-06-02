package com.practicaSpring.ejercicioBlog.services;

import com.practicaSpring.ejercicioBlog.dto.request.BlogRequestDto;
import com.practicaSpring.ejercicioBlog.dto.response.BlogResponseDto;

import java.util.List;
import java.util.UUID;

public interface IBlogService {

    UUID createBlog(BlogRequestDto blogDto);
    BlogResponseDto getById(UUID id);
    List<BlogResponseDto> getAll();

}
