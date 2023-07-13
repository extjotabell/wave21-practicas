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
        List<Cloth> listaRopas = clothRepository.findAll();
        List<ClothesResponseDTO> listaRopasDto = listaRopas.stream().map(
                c -> mapper.map(c, ClothesResponseDTO.class)
        ).collect(Collectors.toList());
        return new ClothesListResponseDTO(listaRopasDto);
    }

    @Override
    public ClothesResponseDTO findOneCloth(Integer id) {
       Optional<Cloth> cloth = clothRepository.findById(id);
        if (cloth == null){
            throw new RuntimeException("No se ha encontrado la prenda de id " +id);
        }
        return mapper.map(cloth, ClothesResponseDTO.class);
    }

    @Override
    public Boolean updateCloth(Integer code, ClothRequestDTO clothRequestDTO) {

        Cloth clothInBd = clothRepository.findById(code).get();
        if( clothInBd == null) return false;
        clothInBd.setBrand(clothRequestDTO.getBrand());
        clothInBd.setName(clothRequestDTO.getName());
        clothInBd.setSize(clothRequestDTO.getSize());
        clothInBd.setQuantity(clothRequestDTO.getQuantity());
        clothInBd.setSalePrice(clothRequestDTO.getSalePrice());
        clothInBd.setColor(clothRequestDTO.getColor());
        clothInBd.setType(clothRequestDTO.getType());

        Cloth saved = clothRepository.save(clothInBd);
        if (saved != null)
            return true;
        return false;
    }

    @Override
    public Boolean deleteCloth(Integer id) {
            ClothesResponseDTO cloth = findOneCloth(id);
            clothRepository.delete(mapper.map(cloth,Cloth.class));
            return true;
    }

    @Override
    public ClothesListResponseDTO searchSaleBySize(String size) {
        List<Cloth> clothList = clothRepository.findBySizeContaining(size);
        return mapper.map(clothList, ClothesListResponseDTO.class);
    }

    @Override
    public ClothesListResponseDTO searchClothesByName(String name) {

        List<Cloth> lista = clothRepository.findByNameContaining(name);
        List<ClothesResponseDTO> listaDTO = lista
                .stream()
                .map(c -> mapper.map(c,ClothesResponseDTO.class ))
                .collect(Collectors.toList());
        return new ClothesListResponseDTO(listaDTO);
    }
}
