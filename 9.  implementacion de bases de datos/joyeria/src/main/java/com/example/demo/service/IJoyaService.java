package com.example.demo.service;

import com.example.demo.model.Joya;

import java.util.List;

public interface IJoyaService {

    Integer saveJoya(Joya joya);

    List<Joya> getJoyas();

    String updateJoya(Joya joya, Integer idModificar);

    String deleteJoya(Integer id);
}
