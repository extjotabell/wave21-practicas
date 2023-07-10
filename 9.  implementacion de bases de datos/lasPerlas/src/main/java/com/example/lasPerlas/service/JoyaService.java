package com.example.lasPerlas.service;

import com.example.lasPerlas.model.Joya;
import com.example.lasPerlas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public List<Joya> getJoyas() {
        List<Joya> joyas = joyaRepository.findAll();
        return joyas.stream()
                .filter(Joya::isSaleOrNo) // Filtrar por el campo saleOrNo verdadero
                .collect(Collectors.toList());
    }

    @Override
    public void saveJoya(Joya joya) {
        joyaRepository.save(joya);
    }

    @Override
    public void deleteJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if (joya != null) {
            joya.setSaleOrNo(false);
            joyaRepository.save(joya);
        }
    }

    @Override
    public Joya findJoya(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }
}
