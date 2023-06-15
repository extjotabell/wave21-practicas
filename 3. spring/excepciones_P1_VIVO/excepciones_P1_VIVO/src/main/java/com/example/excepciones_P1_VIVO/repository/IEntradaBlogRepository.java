package com.example.excepciones_P1_VIVO.repository;

import com.example.excepciones_P1_VIVO.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    void save(EntradaBlog entradaBlog);
    List<EntradaBlog> getAll();
    EntradaBlog getById(Integer id);
}
