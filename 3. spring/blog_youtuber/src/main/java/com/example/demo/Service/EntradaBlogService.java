package com.example.demo.Service;

import com.example.demo.DTO.RequestBlogDTO;
import com.example.demo.model.EntradaBlog;
import org.springframework.http.ResponseEntity;

public interface EntradaBlogService {

    public EntradaBlog saveBlog(RequestBlogDTO model);

}
