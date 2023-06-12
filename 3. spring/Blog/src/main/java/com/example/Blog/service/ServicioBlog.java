package com.example.Blog.service;

import com.example.Blog.dto.request.PostBlogDTO;
import com.example.Blog.dto.response.EntradaDTO;
import com.example.Blog.entity.EntradaBlog;
import com.example.Blog.exception.NotFoundException;
import com.example.Blog.repository.RepositorioBlog;
import com.example.Blog.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioBlog implements IServicioBlog{
    @Autowired
    RepositorioBlog repo;

    @Override
    public void createBlog(PostBlogDTO postBlogDto) {
        EntradaBlog b = Mapper.DTOtoPost(postBlogDto);
        repo.addBlog(b);
    }

    @Override
    public EntradaDTO retornarBlog(int id) {
        List<EntradaBlog> entradas = repo.getEntradas();
        EntradaDTO retorno = null;
        for(EntradaBlog entrada : entradas)
        {
            if(entrada.getId() == id)
                retorno =  new EntradaDTO(entrada.getId(), entrada.getTitulo(), entrada.getNombreAutor(), entrada.getFechaPublicacion());
        }

        if(retorno == null)
        {
            throw new NotFoundException("No se encontró el blog " + id);
        }
        return retorno;
    }

    @Override
    public List<EntradaDTO> retornarTodosLosBlogs() {
        List<EntradaBlog> entradas = repo.getEntradas();
        List<EntradaDTO> entradasARetornar = new ArrayList<>();
        for (EntradaBlog entrada : entradas)
        {
            EntradaDTO e = new EntradaDTO(entrada.getId(), entrada.getTitulo(), entrada.getNombreAutor(), entrada.getFechaPublicacion());
            entradasARetornar.add(e);
        }
        return entradasARetornar;
    }
}
