package com.example.excercise_crud_jpa.service;

import com.example.excercise_crud_jpa.repository.IJoyaRepository;
import com.example.excercise_crud_jpa.entity.Joya;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaService implements IJoyaService {

    IJoyaRepository repository;

    public JoyaService(IJoyaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Joya saveJoya(Joya joya) {
        return repository.save(joya);
    }

    @Override
    public Optional<Joya> findJoya(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Joya> findAllJoya() {
        return repository.findAll();
    }

    @Override
    public Boolean deleteJoya(Long id) {
        Optional<Joya> joya = findJoya(id);
        if (joya.isPresent()) {
            Joya nuevaJoya = joya.get().setVentaONo(false);
            repository.save(nuevaJoya);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateJoya(Long id) {
        Joya joya = findJoya(id);
        if (joya != null) {
            joya.setVentaONo(false);
            saveJoya(joya);
            return true;
        }
        return false;
    }
}
