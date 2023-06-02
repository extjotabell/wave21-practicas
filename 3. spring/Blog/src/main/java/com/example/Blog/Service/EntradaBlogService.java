package com.example.Blog.Service;

import com.example.Blog.DTO.EntradaBlogDTO;
import com.example.Blog.DTO.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface EntradaBlogService {
    public ResponseEntity<ResponseDto> saveBlog(EntradaBlogDTO dto);
}
