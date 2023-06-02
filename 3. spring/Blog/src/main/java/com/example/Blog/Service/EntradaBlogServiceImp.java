package com.example.Blog.Service;

import com.example.Blog.DTO.EntradaBlogDTO;
import com.example.Blog.DTO.ResponseDto;
import com.example.Blog.Entity.EntradaBlog;
import com.example.Blog.Exception.BlogDuplicateException;
import com.example.Blog.Repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EntradaBlogServiceImp implements EntradaBlogService{
    @Autowired
    EntradaBlogRepository repository;
    @Override
    public ResponseEntity<ResponseDto> saveBlog(EntradaBlogDTO dto) {
        EntradaBlog model = new EntradaBlog(
                dto.getId(),
                dto.getNombre(),
                dto.getAutor(),
                dto.getFecha()
        );
        if(repository.saveBlog(model)){
            return new ResponseEntity<>(new ResponseDto("Carga exitosa"), HttpStatus.OK);
        }
        else {
            throw new BlogDuplicateException("Ya existe un Blog ");
        }

    }
}
