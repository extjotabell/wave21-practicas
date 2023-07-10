package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.repository.ClothRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClothService implements IClothService{

    @Autowired
    ClothRepository clothRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        return clothRepository.save(mapper.map(clothRequestDTO,Cloth.class))!=null;
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        return new ClothesListResponseDTO(clothRepository.findAll()
                .stream()
                .map(cloth -> mapper.map(cloth, ClothesResponseDTO.class))
                .collect(Collectors.toList())
        );
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        return mapper.map(clothRepository.findById(id)
                .orElse(null),ClothesResponseDTO.class);
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        Optional<Cloth> clothResponse = clothRepository.findById(code);

        if(!clothResponse.isPresent())
            return false;

        clothRequestDTO.setId(clothResponse.get().getId());

        clothRepository.save(mapper.map(clothRequestDTO,Cloth.class));

        return true;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        Optional<Cloth> clothResponse = clothRepository.findById(id);

        if(!clothResponse.isPresent())
            return false;

        clothRepository.delete(clothResponse.get());
        return true;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        return new ClothesListResponseDTO(clothRepository.findAllBySize(size)
                .stream()
                .map(cloth -> mapper.map(cloth,ClothesResponseDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        return new ClothesListResponseDTO(clothRepository.findAllByNameStartingWith(name)
                .stream()
                .map(cloth -> mapper.map(cloth,ClothesResponseDTO.class))
                .collect(Collectors.toList()));
    }
}
