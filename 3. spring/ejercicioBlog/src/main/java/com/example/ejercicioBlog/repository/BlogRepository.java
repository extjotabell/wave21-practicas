package com.example.ejercicioBlog.repository;

import com.example.ejercicioBlog.entity.EntradaBlog;

public interface BlogRepository {
    Long create(EntradaBlog entradaBlog);
    EntradaBlog buscarPorID(Long id);
}