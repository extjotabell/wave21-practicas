package com.starwars.starwars.services;


import com.starwars.starwars.DTOs.response.CharacterDTO;
import com.starwars.starwars.repositories.characterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {

    characterRepository repository;

    public CharacterService(characterRepository repository) {
        this.repository = repository;
    }


    //mapping

    public List<CharacterDTO> listAllPartiallyMatchingCharacters(String name) {
        List<CharacterDTO> matching = new ArrayList<>();

        repository.findPartiallyByName(name).forEach(
                pc -> {
                    matching.add(new CharacterDTO(pc.getName(),
                            pc.getHeight(),
                            pc.getMass(),
                            pc.getGender(),
                            pc.getHomeworld(),
                            pc.getSpecies()));
                }
        );



        return matching;

    }
}
