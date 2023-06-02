package com.bootcamp.blogenvivo.service;

import com.bootcamp.blogenvivo.dto.requestDTO.RequestBlogDTO;
import com.bootcamp.blogenvivo.dto.responseDTO.ResponseBlogDTO;
import com.bootcamp.blogenvivo.exceptions.BlogNotFoundException;
import com.bootcamp.blogenvivo.exceptions.ExistedBlogException;
import com.bootcamp.blogenvivo.model.Blog;
import com.bootcamp.blogenvivo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public ResponseEntity<?> getBlogById(int id){
        Blog blog = blogRepository.getById(id);
        if(blog == null){
            throw new BlogNotFoundException("No se encontro un blog con id " + id);
        }
        ResponseBlogDTO response = convertToDto(blog);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<?> getAllBlogs(){
        List<Blog> bloglist = blogRepository.getAll();

        List<ResponseBlogDTO> response = new ArrayList<>();
        for (Blog blog: bloglist) {
            response.add(convertToDto(blog));
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<?> insertBlog(RequestBlogDTO requestBlogDTO){
        Blog blog = convertToBlog(requestBlogDTO);
        blog = blogRepository.insertBlog(blog);
        if (blog == null){
            throw new ExistedBlogException("Ya existe un blog con el ID ingresado " + requestBlogDTO.getId());
        }
        ResponseBlogDTO response = convertToDto(blog);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private ResponseBlogDTO convertToDto(Blog blog){
        return new ResponseBlogDTO(blog.getId(), blog.getTitle(), blog.getAuthor(), blog.getPublication());
    }

    private Blog convertToBlog(RequestBlogDTO requestBlogDTO){
        return new Blog(requestBlogDTO.getId(),requestBlogDTO.getTitle(), requestBlogDTO.getAuthor(), requestBlogDTO.getPublication());
    }
}