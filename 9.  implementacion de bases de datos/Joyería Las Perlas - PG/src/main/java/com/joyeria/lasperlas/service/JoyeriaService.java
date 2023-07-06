package com.joyeria.lasperlas.service;

import com.joyeria.lasperlas.model.Joya;
import com.joyeria.lasperlas.repository.JoyeriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JoyeriaService implements IJoyeriaService {

    private JoyeriaRepository repository;

    public JoyeriaService(JoyeriaRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Joya> getJoyas() {
        return repository.findAll();
    }

    @Override
    public Joya saveJoya(Joya joya) {
        return repository.save(joya);
    }

    @Override
    public void deleteJoya(long id) {
        repository.deleteById(id);
    }

    @Override
    public Joya findJoya(long id) {
        return repository.findById(id).orElse(null);
    }
}
