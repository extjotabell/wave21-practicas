package com.example.starWars.services;

import com.example.starWars.dto.CharacterDTO;
import com.example.starWars.repository.CharactersRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterService {

    //inversion de control, instancio el repositorio
    @Autowired
    CharactersRepository charactersRepository;
    //este metodo del servicio busca del repositorio los characters y los transforma en un DTO
    public List<CharacterDTO> tranformEntityToDTO(){

        return charactersRepository.getCharacterList().stream()
                .map(character -> new CharacterDTO(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()
                )).toList();


    }
    public List<CharacterDTO> charactersDTOfiltered(String name){
        return this.tranformEntityToDTO().stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase())).toList() ;


    }
}
