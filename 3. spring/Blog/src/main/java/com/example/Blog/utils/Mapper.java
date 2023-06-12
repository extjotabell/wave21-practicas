package com.example.Blog.utils;

import com.example.Blog.dto.request.PostBlogDTO;
import com.example.Blog.entity.EntradaBlog;

public class Mapper {
    public static EntradaBlog DTOtoPost(PostBlogDTO postBlogDTO)
    {
        return new EntradaBlog(postBlogDTO.getId(), postBlogDTO.getTitulo(), postBlogDTO.getNombreAutor(),
                postBlogDTO.getFechaPublicacion());
    }
}
