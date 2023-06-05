package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryBlogImp implements RepositoryBlog{

    private List<Blog> blogs;

    public RepositoryBlogImp(){
        this.blogs = new ArrayList<>();
    }

    @Override
    public long crear(Blog blog) {
        this.blogs.add(blog);
        return blog.getId();
    }

    @Override
    public Optional<Blog> buscarBlogPorID(Long id) {

        return this.blogs.stream().filter(n->n.getId() == id).findFirst();
    }

    @Override
    public List<Blog> buscarTodos() {
        return this.blogs;
    }
}
