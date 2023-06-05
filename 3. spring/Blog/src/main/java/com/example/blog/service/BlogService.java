package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import com.example.blog.model.Blog;
import com.example.blog.repository.interfaces.IBlogRepository;
import com.example.blog.service.interfaces.IBlogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BlogService implements IBlogService {
    private IBlogRepository blogRepository;
    private ModelMapper modelMapper;

    public BlogService(IBlogRepository blogRepository, ModelMapper modelMapper){
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public BlogDTO create(BlogDTO blog) {
        if(blogRepository.getBlogById(blog.getId()).isPresent()) return null;

        blogRepository.create(modelMapper.map(blog, Blog.class));
        return blog;
    }
}
