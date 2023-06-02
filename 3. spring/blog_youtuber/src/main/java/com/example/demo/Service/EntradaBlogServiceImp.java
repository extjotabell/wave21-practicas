package com.example.demo.Service;

import com.example.demo.DTO.RequestBlogDTO;
import com.example.demo.model.EntradaBlog;
import com.example.demo.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EntradaBlogServiceImp implements EntradaBlogService{

    @Autowired
    private EntradaBlogRepository entradaBlogRepository;

    @Override
    public EntradaBlog saveBlog(RequestBlogDTO model) {
        EntradaBlog entradaBlog = new EntradaBlog(model.getId(), model.getTitle(), model.getAuthor(), model.getDate());
        entradaBlogRepository.saveBlog(entradaBlog);
        return entradaBlog;
    }
}
