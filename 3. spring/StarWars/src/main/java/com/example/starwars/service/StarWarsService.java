package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repository.StarWarsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService {
    private ModelMapper modelMapper;
    private StarWarsRepository starWarsRepository;
    public StarWarsService(ModelMapper modelMapper, StarWarsRepository starWarsRepository){
        this.modelMapper = modelMapper;
        this.starWarsRepository = starWarsRepository;
    }

    public List<CharacterDTO> findCharacterByName(String name){
        return starWarsRepository.findCharacterByName(name).stream()
                .map(character -> modelMapper.map(character, CharacterDTO.class))
                .collect(Collectors.toList());
    }
}
