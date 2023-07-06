package com.JoyeriaLasPerlas.demoDBJoyeria.service;

import com.JoyeriaLasPerlas.demoDBJoyeria.model.Joya;
import com.JoyeriaLasPerlas.demoDBJoyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaService implements IJoyaService {
    private final IJoyaRepository joyaRepo;

    public JoyaService(IJoyaRepository stuRepo) {
        this.joyaRepo = stuRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoya() {
        List<Joya> joyaList = joyaRepo.findAll();
        List<Joya> joyasDisponibles = joyaList.stream().filter(joya -> joya.getVentaONo().equals(true)).toList();
        return joyasDisponibles;
    }

    @Override
    public void saveJoya(Joya stu) {
        joyaRepo.save(stu);
    }

    @Override
    public void deleteJoya(Integer id) {
        Joya joya = joyaRepo.findById(id).orElse(null);
        joya.setVentaONo(false);
        joyaRepo.save(joya);
    }

    @Override
    public Joya findJoya(Integer id) {
        Joya stu = joyaRepo.findById(id).orElse(null);
        return stu;
    }
}
