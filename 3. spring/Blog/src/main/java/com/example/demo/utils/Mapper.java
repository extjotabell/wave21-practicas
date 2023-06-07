package com.example.demo.utils;

import com.example.demo.dto.BlogResponseDTO;
import com.example.demo.model.Blog;

public class Mapper {
    public static BlogResponseDTO DTOfromBlog(Blog blog){
        return new BlogResponseDTO(
                blog.getTitle(),
                blog.getAuthorName(),
                blog.getDate()
        );
    }
}