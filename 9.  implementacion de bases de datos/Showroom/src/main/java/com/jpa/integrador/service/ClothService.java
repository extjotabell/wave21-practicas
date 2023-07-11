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

        Cloth clothe = clothRepository.InsertClothe(
                mapper.map(clothRequestDTO, Cloth.class));

       return clothe.toString().isEmpty();

    }

    @Override
    public ClothesListResponseDTO findAllCloth() {
        return new ClothesListResponseDTO(
            clothRepository.findAllClothes()
                    .stream()
                    .map(
                            c -> mapper.map(c, ClothesResponseDTO.class)
                    ).collect(Collectors.toList())
        );
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
        return mapper.map(clothRepository.findClothe(id), ClothesResponseDTO.class);
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
        return new ClothesListResponseDTO(
                clothRepository.findClotheBySize(size)
                        .stream()
                        .map(
                                c -> mapper.map(c, ClothesResponseDTO.class)
                        ).collect(Collectors.toList())
        );
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {
        return new ClothesListResponseDTO(
                clothRepository.findByNameContainsCloth(name)
                        .stream()
                        .map(
                                c -> mapper.map(c, ClothesResponseDTO.class)
                        ).collect(Collectors.toList())
        );

    }
}
