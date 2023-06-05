package com.bootcamp.blog.utilitie;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.BlogIdDTO;
import com.bootcamp.blog.entity.Blog;

public class Mapper {

    public static Blog crearBlogDesdeDTO(BlogDTO dto){
        Blog blog = new Blog();
        blog.setId(dto.getId());
        blog.setNombre(dto.getNombre());
        blog.setTitulo(dto.getTitulo());
        blog.setFecha(dto.getFecha());
        return blog;
    }

    public static BlogDTO crearDTOdesdeBlog(Blog blog){
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setNombre(blog.getNombre());
        dto.setTitulo(blog.getTitulo());
        dto.setFecha(blog.getFecha());
        return dto;
    }

    public static BlogIdDTO crearIDDTOdesdeBlog(Blog blog){
        BlogIdDTO dto = new BlogIdDTO();
        dto.setNombre(blog.getNombre());
        dto.setTitulo(blog.getTitulo());
        dto.setFecha(blog.getFecha());
        return dto;
    }

}
