package com.example.Blog.Repository;

import com.example.Blog.Entity.EntradaBlog;
import com.example.Blog.Service.EntradaBlogService;

public interface EntradaBlogRepository {
    public boolean saveBlog(EntradaBlog model);

}
