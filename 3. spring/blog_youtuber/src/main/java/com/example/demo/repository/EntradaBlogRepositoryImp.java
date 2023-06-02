package com.example.demo.repository;


import com.example.demo.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class EntradaBlogRepositoryImp implements EntradaBlogRepository {

    private final HashMap<String, EntradaBlog> blogs;

    public EntradaBlogRepositoryImp(){
        this.blogs = new HashMap<>();
    }
    @Override
    public void saveBlog(EntradaBlog model) {
        String newId = model.getIdBlog();
        if (this.blogs.containsKey(newId)){
            System.out.println("Ya existe un blog con ese id");
            throw new RuntimeException("Ya existe un blog con ese id");
        }
        this.blogs.put(model.getIdBlog(),model);
        System.out.println(this.blogs);
    }

}
