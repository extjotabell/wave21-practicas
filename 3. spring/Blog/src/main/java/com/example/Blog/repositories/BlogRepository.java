package com.example.Blog.repositories;

import com.example.Blog.dto.BlogResponseDTO;
import com.example.Blog.model.Blog;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository {
    private final List<Blog> blogs = new ArrayList<>();

    public Optional<Blog> findBlogById(int id){
        return blogs
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public int createBlog(final Blog blog) {
        blog.setId(blogs.size());
        blogs.add(blog);
        //TODO esto deberia de buscar q no existe un blog con ese id, o en todo caso generarle un id e ingresarlo sin el mismo
        return blog.getId();
    }

    public List<Blog> getAllBlogs() {
        return blogs;
    }
}
