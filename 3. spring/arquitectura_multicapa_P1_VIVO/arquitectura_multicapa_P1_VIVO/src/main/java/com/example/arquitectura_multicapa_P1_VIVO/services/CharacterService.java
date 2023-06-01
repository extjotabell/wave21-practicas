package com.example.arquitectura_multicapa_P1_VIVO.services;

import com.example.arquitectura_multicapa_P1_VIVO.dto.response.CharacterResponseDTO;
import com.example.arquitectura_multicapa_P1_VIVO.entity.Characters;
import com.example.arquitectura_multicapa_P1_VIVO.repository.CharactersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {

    CharactersRepository repository;

    public CharacterService(CharactersRepository repository) {
        this.repository = repository;
    }

    public List<CharacterResponseDTO> listCharacters(String name) {

        List<Characters> characters = repository.findCharacterByName(name);

        List<CharacterResponseDTO> charactersDTO = characters
                .stream()
                .map(character -> {
                    var characterDTO = new CharacterResponseDTO();
                    characterDTO.setName(character.getName());
                    characterDTO.setHeight(character.getHeight());
                    characterDTO.setMass(character.getMass());
                    characterDTO.setGender(character.getGender());
                    characterDTO.setHomeworld(character.getHomeworld());
                    characterDTO.setSpecies(character.getSpecies());
                    return characterDTO;
                })
                .toList();

        return charactersDTO;
    }
}
