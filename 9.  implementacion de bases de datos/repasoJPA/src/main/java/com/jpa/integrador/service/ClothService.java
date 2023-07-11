package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.repository.ClothRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClothService implements IClothService{

    @Autowired
    ClothRepository clothRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public Boolean addCloth(ClothRequestDTO clothRequestDTO) {
        clothRepository.save(mapper.map(clothRequestDTO, Cloth.class));
        return true;
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        ClothesListResponseDTO dto = new ClothesListResponseDTO();
        dto.setClothes(
                clothRepository.findAll()
                .stream()
                .map(cloth -> mapper.map(cloth, ClothesResponseDTO.class))
                .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        Optional<Cloth> cloth = clothRepository.findById(id);
        return cloth.map(value -> mapper.map(value, ClothesResponseDTO.class)).orElse(null);
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        Optional<Cloth> cloth = clothRepository.findById(code);
        if(cloth.isPresent()){
            cloth.get().setName(clothRequestDTO.getName());
            cloth.get().setSalePrice(clothRequestDTO.getSalePrice());
            cloth.get().setBrand(clothRequestDTO.getBrand());
            cloth.get().setColor(clothRequestDTO.getColor());
            cloth.get().setSize(clothRequestDTO.getSize());
            cloth.get().setQuantity(clothRequestDTO.getQuantity());
            clothRepository.save(cloth.get());
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        Optional<Cloth> cloth = clothRepository.findById(id);
        if(cloth.isPresent()){
            clothRepository.delete(cloth.get());
            return true;
        }
        return false;
    }

    @Override
    public ClothesListResponseDTO searchClotheBySize(String size) {
        ClothesListResponseDTO dto = new ClothesListResponseDTO();
        dto.setClothes(
                clothRepository.findBySize(size)
                .stream()
                .map(cloth -> mapper.map(cloth, ClothesResponseDTO.class))
                .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        ClothesListResponseDTO dto = new ClothesListResponseDTO();
        dto.setClothes(
                clothRepository.findByName(name)
                .stream()
                .map(cloth -> mapper.map(cloth, ClothesResponseDTO.class))
                .collect(Collectors.toList()));
        return dto;
    }
}
