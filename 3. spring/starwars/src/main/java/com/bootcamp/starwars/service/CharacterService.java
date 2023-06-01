package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.repository.CharacterRepository;
import com.bootcamp.starwars.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    public List<CharacterDTO> findByName(String name){
        return characterRepository.findByName(name).stream().map(Mapper::mapToDTO).toList();
    }
}
