package com.example.excepciones_P1_VIVO.controller;

import com.example.excepciones_P1_VIVO.dto.request.EntradaBlogRequestDTO;
import com.example.excepciones_P1_VIVO.dto.response.EntradaBlogResponseDTO;
import com.example.excepciones_P1_VIVO.entity.EntradaBlog;
import com.example.excepciones_P1_VIVO.service.EntradaBlogService;
import com.example.excepciones_P1_VIVO.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EntradaBlogController {

    @Autowired
    IEntradaBlogService service;

    @PostMapping("blog")
    ResponseEntity<?> crearEntrada(@RequestBody EntradaBlogRequestDTO entradaBlogRequestDTO) {
        service.save(entradaBlogRequestDTO);
        return new ResponseEntity<>("Se ha creado el Post con ID: " + entradaBlogRequestDTO.getId(), HttpStatus.OK);
    }
    @GetMapping("blog/{id}")
    ResponseEntity<EntradaBlogResponseDTO> getBlogId(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping("blogs")
    ResponseEntity<List<EntradaBlogResponseDTO>> getAllBlogs() {
        List<EntradaBlogResponseDTO> entradaBlogResponseDTOList = service.getAll();
        return new ResponseEntity<>(entradaBlogResponseDTOList, HttpStatus.OK);
    }
}
