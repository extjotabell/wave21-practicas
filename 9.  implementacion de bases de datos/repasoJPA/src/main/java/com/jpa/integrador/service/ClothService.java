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
        clothRepository.save(mapper.map(clothRequestDTO,Cloth.class));
        return true;
    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        return null;
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        return null;
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {
        return null;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
        return null;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        return null;
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        return null;
    }
}
