package com.blog.blog.service;

import com.blog.blog.dto.BlogDTO;
import com.blog.blog.exception.EntradaBlogExisteException;
import com.blog.blog.exception.EntradaBlogNotFound;

import java.util.List;

public interface BlogService {

    String crear(BlogDTO blogDTO) throws EntradaBlogExisteException;

    BlogDTO buscarPorId(Long id) throws EntradaBlogNotFound;

    List<BlogDTO> buscarTodos();
}
