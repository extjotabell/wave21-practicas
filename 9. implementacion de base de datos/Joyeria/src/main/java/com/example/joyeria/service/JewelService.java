package com.example.joyeria.service;

import com.example.joyeria.dto.JewelCreationDTO;
import com.example.joyeria.dto.JewelDTO;
import com.example.joyeria.model.Jewel;
import com.example.joyeria.repository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class JewelService {
    private final IJewelRepository jewelRepository;
    private final ModelMapper modelMapper;

    public JewelService(IJewelRepository jewelRepository, ModelMapper modelMapper){
        this.jewelRepository = jewelRepository;
        this.modelMapper = modelMapper;
    }
    public String create(JewelCreationDTO jewelCreationDTO){
        Jewel jewel = modelMapper.map(jewelCreationDTO, Jewel.class);
        jewel.setStatus(Boolean.TRUE);

        return "Id: " + jewelRepository.save(jewel).getId();
    }

    public List<JewelDTO> getAll(){
        return jewelRepository.findAll().stream()
                .filter(Jewel::getStatus)
                .map(jewel -> modelMapper.map(jewel, JewelDTO.class))
                .collect(Collectors.toList());
    }

    public void delete(Long id){
        Jewel jewel = jewelRepository.findById(id)
                            .orElseThrow();

        jewel.setStatus(Boolean.FALSE);

        jewelRepository.save(jewel);
    }

    public JewelDTO update(Long id, JewelDTO jewelDTO){
        if(!jewelRepository.existsById(id) || !Objects.equals(id, jewelDTO.getId())) throw new RuntimeException("Id incorrecto");

        Jewel jewel = modelMapper.map(jewelDTO, Jewel.class);

        return modelMapper.map(jewelRepository.save(jewel), JewelDTO.class);
    }
}
