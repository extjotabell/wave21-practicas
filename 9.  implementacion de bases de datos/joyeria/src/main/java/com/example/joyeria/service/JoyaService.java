package com.example.joyeria.service;

import com.example.joyeria.model.dto.JoyaDTO;
import com.example.joyeria.model.entity.Joya;
import com.example.joyeria.repository.JoyaRepository;
import org.springframework.stereotype.Service;

@Service
public class JoyaService {
    private final JoyaRepository joyaRepository;

    public JoyaService(JoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    public JoyaDTO createJoya(JoyaDTO joyaDTO) {
        Joya joya = convertToJoya(joyaDTO);
        joyaRepository.save(joya);
        return convertToJoyaDTO(joya);
    }

    private Joya convertToJoya(JoyaDTO joyaDTO){
        Joya joya = new Joya();
        joya.setNombre(joyaDTO.getNombre());
        joya.setMaterial(joyaDTO.getMaterial());
        joya.setPeso(joyaDTO.getPeso());
        joya.setParticularidad(joyaDTO.getParticularidad());
        joya.setPoseePiedra(joyaDTO.getPosee_piedra());
        joya.setVentaONo(joyaDTO.getVentaONo());
        return joya;
    }

    private JoyaDTO convertToJoyaDTO(Joya joya){
        JoyaDTO joyaDTO = new JoyaDTO();
        joyaDTO.setNombre(joya.getNombre());
        joyaDTO.setMaterial(joya.getMaterial());
        joyaDTO.setPeso(joya.getPeso());
        joyaDTO.setParticularidad(joya.getParticularidad());
        joyaDTO.setPosee_piedra(joya.getPoseePiedra());
        joyaDTO.setVentaONo(joya.getVentaONo());
        return joyaDTO;
    }
}
