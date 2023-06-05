package com.example.ejercicioBlog.repository.impl;

import com.example.ejercicioBlog.entity.EntradaBlog;
import com.example.ejercicioBlog.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    private List<EntradaBlog> blogs;

    public BlogRepositoryImpl(){
        this.blogs=new ArrayList<>();
    }

    @Override
    public Long create(EntradaBlog entradaBlog) {


        this.blogs.add(entradaBlog);

        return entradaBlog.getId();
    }

    @Override
    public EntradaBlog buscarPorID(Long id) {
        for(EntradaBlog entrada : this.blogs){
            if(entrada.getId() == id){
                return entrada;
            }
        }
        return null;
    }
}
