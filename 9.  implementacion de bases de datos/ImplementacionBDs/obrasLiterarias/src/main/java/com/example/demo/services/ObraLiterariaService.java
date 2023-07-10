package com.example.demo.services;

import com.example.demo.domain.ObraLiteraria;

import java.util.List;

public interface ObraLiterariaService {

    ObraLiteraria save(ObraLiteraria obraLiteraria);
    List<ObraLiteraria> getAllByAutor(String autor);

    List<ObraLiteraria> findAll();

    //List<ObraLiteraria> getObraLiterariaByNombreAndOrder(String nombre, String orden);
}
