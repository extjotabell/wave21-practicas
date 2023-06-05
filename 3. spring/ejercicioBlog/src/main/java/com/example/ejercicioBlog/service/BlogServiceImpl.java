package com.example.ejercicioBlog.service;

import com.example.ejercicioBlog.dto.BlogDTO;
import com.example.ejercicioBlog.entity.EntradaBlog;
import com.example.ejercicioBlog.exception.EntradaBlogExisteException;
import com.example.ejercicioBlog.repository.BlogRepository;
import com.example.ejercicioBlog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public String crear(BlogDTO blogDTO) throws EntradaBlogExisteException {
        if(buscarPorId(blogDTO.getId())!=null)
            throw new EntradaBlogExisteException("El blog con id "+blogDTO.getId()+" ya existe.");
        return "La entidad ha sido creada correctamente con el id:"+blogRepository.create(mapDtoToEntity(blogDTO));
    }

    @Override
    public BlogDTO buscarPorId(Long id) {
        return mapEntityToDTO(blogRepository.buscarPorID(id));
    }

    public EntradaBlog mapDtoToEntity(BlogDTO blogDTO){
        return new EntradaBlog(blogDTO.getId(),blogDTO.getTitulo(),blogDTO.getNombreAutor(),blogDTO.getFechaPublicacion());
    }

    public BlogDTO mapEntityToDTO(EntradaBlog entradaBlog){
        return new BlogDTO(entradaBlog.getId(),entradaBlog.getTitulo(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion());
    }
}
