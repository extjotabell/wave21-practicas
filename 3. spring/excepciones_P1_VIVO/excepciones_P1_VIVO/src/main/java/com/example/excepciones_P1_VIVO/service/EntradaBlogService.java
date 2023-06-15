package com.example.excepciones_P1_VIVO.service;

import com.example.excepciones_P1_VIVO.dto.request.EntradaBlogRequestDTO;
import com.example.excepciones_P1_VIVO.dto.response.EntradaBlogResponseDTO;
import com.example.excepciones_P1_VIVO.entity.EntradaBlog;
import com.example.excepciones_P1_VIVO.exception.BadRequestException;
import com.example.excepciones_P1_VIVO.exception.NotFoundException;
import com.example.excepciones_P1_VIVO.repository.EntradaBlogRepository;
import com.example.excepciones_P1_VIVO.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements IEntradaBlogService{

    @Autowired
    IEntradaBlogRepository repository;

    @Override
    public void save(EntradaBlogRequestDTO entradaBlogRequestDTO) {
        EntradaBlog blogIdExiste = repository.getById(entradaBlogRequestDTO.getId());
        if (blogIdExiste != null) {
            throw new BadRequestException("El blog con ID: " + entradaBlogRequestDTO.getId() + ", ya existe.");
        }
        repository.save(new EntradaBlog(
                entradaBlogRequestDTO.getId(),
                entradaBlogRequestDTO.getTitulo(),
                entradaBlogRequestDTO.getNombreAutor(),
                entradaBlogRequestDTO.getFechaPublicacion()
        ));
    }

    @Override
    public List<EntradaBlogResponseDTO> getAll() {
        List<EntradaBlog> entradaBlogList = repository.getAll();


        return entradaBlogList.stream()
                .map(n -> new EntradaBlogResponseDTO(
                        n.getTitulo(),
                        n.getNombreAutor(),
                        n.getFechaPublicacion()
                )).collect(Collectors.toList());
    }

    @Override
    public EntradaBlogResponseDTO getById(Integer id) {
        EntradaBlog entradaBlog = repository.getById(id);
        if (entradaBlog == null) {
            throw new NotFoundException("Blog ID: " + id + ", no fue encontrado");
        }
        return new EntradaBlogResponseDTO(
                entradaBlog.getTitulo(),
                entradaBlog.getNombreAutor(),
                entradaBlog.getFechaPublicacion()
        );
    }
}
