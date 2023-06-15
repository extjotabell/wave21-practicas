package com.example.excepciones_P1_VIVO.service;

import com.example.excepciones_P1_VIVO.dto.request.EntradaBlogRequestDTO;
import com.example.excepciones_P1_VIVO.dto.response.EntradaBlogResponseDTO;
import com.example.excepciones_P1_VIVO.entity.EntradaBlog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEntradaBlogService {

    void save(EntradaBlogRequestDTO entradaBlogRequestDTO);
    List<EntradaBlogResponseDTO> getAll();
    EntradaBlogResponseDTO getById(Integer id);

}
