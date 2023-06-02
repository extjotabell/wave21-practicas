package com.example.Blog.service;

import com.example.Blog.dto.BlogDTO;
import com.example.Blog.dto.BlogIDDTO;
import com.example.Blog.dto.BlogResponseDTO;
import com.example.Blog.exceptions.BlogNotFoundException;
import com.example.Blog.model.Blog;
import com.example.Blog.utils.Mapper;
import com.example.Blog.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public List<BlogResponseDTO> getAllBlogs() {
       List<BlogResponseDTO> blogs = blogRepository.getAllBlogs().stream()
               .map(Mapper::DTOfromBlog).collect(Collectors.toList());
       return  blogs;
    }

    public BlogResponseDTO getBlog(Integer id) {
        BlogResponseDTO blog = blogRepository.findBlogById(id)
                .map(Mapper::DTOfromBlog) // caso feliz
                .orElseThrow(() -> new BlogNotFoundException("No existe la excepcion de id " + id + "!")); // caso triste
        return blog;
    }

    public BlogIDDTO createBlog(BlogDTO blogDTO) {

        BlogIDDTO blogID = new BlogIDDTO();
        Blog blog = new Blog();

        blog.setId(blogDTO.getId());
        blog.setDate(blogDTO.getDate());
        blog.setAuthorName(blogDTO.getAuthorName());
        blog.setTitle(blogDTO.getTitle());

        //TODO falta definir el manejo de las excepciones todavia
        try{
            blogID.setId(blogRepository.createBlog(blog));
        }catch(Exception e){
            throw e;
        }

        return blogID;
    }
}

