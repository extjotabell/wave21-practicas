package com.bootcamp.starwars.utils;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.model.Character;

public class Mapper {

    public static CharacterDTO mapToDTO(Character character) {
        return new CharacterDTO(character.getName(),
                character.getHeight(),
                character.getMass(),
                character.getGender(),
                character.getHomeworld(),
                character.getSpecies());
    }
}
