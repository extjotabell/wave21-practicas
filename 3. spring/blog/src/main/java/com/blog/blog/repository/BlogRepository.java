package com.blog.blog.repository;

import com.blog.blog.dto.BlogDTO;
import com.blog.blog.entity.EntradaBlog;

import java.util.List;

public interface BlogRepository {
    Long create(EntradaBlog entradaBlog);
    EntradaBlog buscarPorID(Long id);

    List<EntradaBlog> buscarTodos();
}
