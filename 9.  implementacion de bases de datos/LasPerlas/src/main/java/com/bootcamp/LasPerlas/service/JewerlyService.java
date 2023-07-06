package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.DTO.request.JewelDTORequest;
import com.bootcamp.LasPerlas.DTO.response.JewelDTO;
import com.bootcamp.LasPerlas.DTO.response.JewelryResponseDTO;
import com.bootcamp.LasPerlas.DTO.response.MessageDTO;
import com.bootcamp.LasPerlas.model.Jewel;
import com.bootcamp.LasPerlas.repository.IJewelryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewerlyService {

    ModelMapper modelMapper;
    private IJewelryRepository jewelryRepository;

    public JewerlyService(ModelMapper modelMapper, IJewelryRepository jewelryRepository) {
        this.modelMapper = modelMapper;
        this.jewelryRepository = jewelryRepository;
    }

    public MessageDTO createJewel(JewelDTORequest newJewelData){
        Jewel createdJewel = jewelryRepository.save(modelMapper.map(newJewelData, Jewel.class));
        return new MessageDTO(0,"nro_identificador: " + createdJewel.getNroIdentificatorio());
    }

    public JewelryResponseDTO getAllJewerly(){
        List<Jewel> jewels = jewelryRepository.findAll();
        return new JewelryResponseDTO(0,
                jewels.stream()
                        .filter(Jewel::isSaleOrNot)
                        .map(jewel -> modelMapper.map(jewel, JewelDTO.class))
                        .toList());
    }

    public void deleteJewel(long id){
        Jewel storedJewel = jewelryRepository.findById(id).orElseThrow(() -> new RuntimeException());
        jewelryRepository.delete(storedJewel);
    }
}
