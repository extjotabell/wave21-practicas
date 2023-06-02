package com.example.Blog.utils;

import com.example.Blog.dto.BlogResponseDTO;
import com.example.Blog.model.Blog;

public class Mapper {
    public static BlogResponseDTO DTOfromBlog(Blog blog){
        return new BlogResponseDTO(
                blog.getTitle(),
                blog.getAuthorName(),
                blog.getDate()
        );
    }
}
