package com.example.lasPerlas.service;

import com.example.lasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {
    List<Joya> getJoyas();
    void saveJoya(Joya joya);
    void deleteJoya(Long id);
    Joya findJoya(Long id);
}
