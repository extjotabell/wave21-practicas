package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.BlogIdDTO;
import com.bootcamp.blog.entity.Blog;
import com.bootcamp.blog.exception.BlogNotFoundExcepcion;
import com.bootcamp.blog.exception.ExistingBlogException;
import com.bootcamp.blog.repository.RepositoryBlog;
import com.bootcamp.blog.utilitie.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ServicesBlogImp implements ServicesBlog{
    RepositoryBlog repo;

    public ServicesBlogImp(RepositoryBlog repo){
        this.repo = repo;
    }

    @Override
    public long crear(BlogDTO blogDTO) {
        if(!this.repo.buscarBlogPorID(blogDTO.getId()).isEmpty()){
            throw new ExistingBlogException("El id" + blogDTO.getId() + "Ya se encuentra en la BBDD");
        }

        this.repo.crear(Mapper.crearBlogDesdeDTO(blogDTO));
        return 0;
    }



    @Override
    public List<BlogDTO> buscarTodos() {
        List<BlogDTO> blogs = new ArrayList<>();

        for(Blog blog : this.repo.buscarTodos()){
            blogs.add(Mapper.crearDTOdesdeBlog(blog));
        }
        return blogs;
    }

    @Override
    public BlogIdDTO buscarBlogPorID(Long id) {
        if(this.repo.buscarBlogPorID(id).isEmpty()){
            throw new BlogNotFoundExcepcion("Blog Not Found");
        }
            return Mapper.crearIDDTOdesdeBlog(this.repo.buscarBlogPorID(id).get());
    }
}
