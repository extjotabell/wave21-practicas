package com.practicaJPA.joyeria.service;

import com.practicaJPA.joyeria.dto.JoyaDTO;
import com.practicaJPA.joyeria.dto.MessageDTO;
import com.practicaJPA.joyeria.model.Joya;
import com.practicaJPA.joyeria.repository.IJoyaRepository;
import com.practicaJPA.joyeria.service.interfaces.IJoyaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    private final IJoyaRepository iJoyaRepository;
    ModelMapper mapper;


    public JoyaService(IJoyaRepository iJoyaRepository) {
        this.iJoyaRepository = iJoyaRepository;
        this.mapper = new ModelMapper();
    }


    @Override
    public JoyaDTO saveJoya(JoyaDTO joyaDTO) {

        Joya joya = mapper.map(joyaDTO, Joya.class);

        iJoyaRepository.save(joya);
        return mapper.map(joya, JoyaDTO.class);
    }

    @Override
    public JoyaDTO getJoyayById(Integer id) {
        Joya joya = iJoyaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontramos lo que buscabas"));

        return mapper.map(joya, JoyaDTO.class);
    }

    @Override
    public List<JoyaDTO> getAllJoya() {
        List<Joya> joyas = iJoyaRepository.findAll();
        return joyas.stream()
                .map(joya -> mapper.map(joya, JoyaDTO.class))
                .toList();
    }

    @Override
    public MessageDTO deleteJoya(Integer id) {
        if(!iJoyaRepository.existsById(id)){
            throw new RuntimeException("No pudimos borrar las cosas");
        }
        iJoyaRepository.deleteById(id);
        return null;

    }

}
