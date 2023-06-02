package com.blog.blog.repository.impl;

import com.blog.blog.dto.BlogDTO;
import com.blog.blog.entity.EntradaBlog;
import com.blog.blog.repository.BlogRepository;
import com.blog.blog.service.impl.BlogServiceImpl;
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

    public EntradaBlog buscarPorID(Long id){
        for(EntradaBlog entrada : this.blogs){
            if(entrada.getId() == id){
                return entrada;
            }
        }
        return null;
    }

    @Override
    public List<EntradaBlog> buscarTodos() {
        return this.blogs;
    }

}
