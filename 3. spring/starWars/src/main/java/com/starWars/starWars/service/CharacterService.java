package com.starWars.starWars.service;

import com.starWars.starWars.dto.response.CharacterInfoDTO;
import com.starWars.starWars.model.Character;
import com.starWars.starWars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<Character> listCharacter(){

        List<Character> character = repository.getCharacterJson();

        return character;

    }

    public List<CharacterInfoDTO> findCharacter(String name){
        List<CharacterInfoDTO> characters = repository
                .findByName(name)
                .stream()
                .map(c -> new CharacterInfoDTO(c.getName(),c.getHeight(),c.getMass(),c.getGender(),c.getHomeworld(), c.getSpecies()))
                .toList();
        return characters;
    }

}
