package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private HashMap<Integer, Blog> blogDatabase = new HashMap<>();

    public BlogRepositoryImpl() {}

    @Override
    public Blog getById(Integer id) {
        return blogDatabase.get(id);
    }

    @Override
    public List<Blog> getAll() {
        return blogDatabase.values().stream().toList();
    }

    @Override
    public Blog insertBlog(Blog blog) {
        if (blogDatabase.containsKey(blog.getId())){
            return null;
        }
        blogDatabase.put(blog.getId(), blog);
        return blog;
    }
}
