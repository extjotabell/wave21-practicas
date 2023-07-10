package com.example.demo.service;

import com.example.demo.model.Joya;
import com.example.demo.repository.JoyaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    private final JoyaRepository joyaRepo;

    public JoyaService(JoyaRepository joyaRepo){
        this.joyaRepo = joyaRepo;
    }

    @Override
    public Integer saveJoya(Joya joya) {
       return joyaRepo.save(joya).getNro_identificatorio();
    }

    @Override
    public List<Joya> getJoyas() {
        return joyaRepo.findAll();
    }

    @Override
    public String updateJoya(Joya joya, Integer idModificar) {
        Joya joyaEncontrada = joyaRepo.findById(idModificar).orElse(null);
        joyaEncontrada.setNombre(joya.getNombre());
        joyaEncontrada.setMaterial(joya.getMaterial());
        joyaEncontrada.setPeso(joya.getPeso());
        joyaEncontrada.setParticularidad(joya.getParticularidad());
        joyaEncontrada.setPosee_piedra(joya.isPosee_piedra());
        joyaEncontrada.setVentaONo(joya.isVentaONo());

        this.saveJoya(joyaEncontrada);
        return "Joya modificada";
    }

    @Override
    public String deleteJoya(Integer id) {
        Joya joya = joyaRepo.findById(id).orElse(null);
        joya.setVentaONo(false);
        this.saveJoya(joya);
        return "Eliminado logicamente";
    }
}
