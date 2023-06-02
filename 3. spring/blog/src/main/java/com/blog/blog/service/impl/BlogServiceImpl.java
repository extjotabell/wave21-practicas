package com.blog.blog.service.impl;

import com.blog.blog.dto.BlogDTO;
import com.blog.blog.entity.EntradaBlog;
import com.blog.blog.exception.EntradaBlogExisteException;
import com.blog.blog.exception.EntradaBlogNotFound;
import com.blog.blog.repository.BlogRepository;
import com.blog.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public String crear(BlogDTO blogDTO) throws EntradaBlogExisteException {
        if(blogRepository.buscarPorID(blogDTO.getId())!=null)
            throw new EntradaBlogExisteException("El blog con id "+blogDTO.getId()+" ya existe.");
        return "La entidad ha sido creada correctamente con el id:"+blogRepository.create(mapDtoToEntity(blogDTO));
    }

    @Override
    public BlogDTO buscarPorId(Long id) throws EntradaBlogNotFound {
        EntradaBlog entradaBlog = blogRepository.buscarPorID(id);

        if(entradaBlog==null)
            throw new EntradaBlogNotFound("El blog con id "+id+ " no existe.");
        return mapEntityToDTO(blogRepository.buscarPorID(id));
    }

    @Override
    public List<BlogDTO> buscarTodos() {
        return mapEntityListToDto(blogRepository.buscarTodos());
    }

    public EntradaBlog mapDtoToEntity(BlogDTO blogDTO){
        return new EntradaBlog(blogDTO.getId(),blogDTO.getTitulo(),blogDTO.getNombreAutor(),blogDTO.getFechaPublicacion());
    }

    public BlogDTO mapEntityToDTO(EntradaBlog entradaBlog){
        return new BlogDTO(entradaBlog.getId(),entradaBlog.getTitulo(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion());
    }

    public List<BlogDTO> mapEntityListToDto(List<EntradaBlog> entradaBlogs){
        return entradaBlogs.stream()
                .map(entradaBlog -> new BlogDTO(entradaBlog.getId(),entradaBlog.getTitulo(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion()))
                .collect(Collectors.toList());
    }
}
