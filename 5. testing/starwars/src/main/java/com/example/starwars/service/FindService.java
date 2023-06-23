package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.model.Character;
import com.example.starwars.repository.ICharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindService implements IFindService{
    private ICharacterRepository characterRepository;
    private ModelMapper mapper;

    public FindService(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
        mapper = new ModelMapper();
    }


    @Override
    public List<CharacterDTO> find(String query) {
        List<Character> characters;
        characters = characterRepository.findAllByNameContains(query);
        /*characters = new ArrayList<>();*/

        List<CharacterDTO> characterDTOS = characters
                .stream()
                //.map(Mapper::DTOFromCharacter)
                .map(character -> {
                    CharacterDTO characterDTO = mapper.map(character, CharacterDTO.class);
                    return characterDTO;
                })
                .collect(Collectors.toList());

        return characterDTOS;
    }
}
