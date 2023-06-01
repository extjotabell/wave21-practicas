package com.ejercicio1.starWars.service;

import com.ejercicio1.starWars.dto.CharacterDTO;
import com.ejercicio1.starWars.repositories.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterSearchService {
    private List<Character> characters;

    public CharacterSearchService() {
        characters = new ArrayList<>();
        characters.add(new Character("Luke Skywalker", 172, 77, "Blond", "Fair", "Blue", "19 BBY", "Male", "Tatooine", "Human"));
        characters.add(new Character("Darth Vader", 202, 136, "No Hair", "White", "Yellow", "41.9 BBY", "Male", "Tatooine", "Human"));
        characters.add(new Character("Darth Maul", 175, 80, "None", "Red", "Yellow", "54 BBY", "Male", "Dathomir", "Zabrak"));
        characters.add(new Character("Princess Leia Organa", 150, 49, "Brown", "Light", "Brown", "19 BBY", "Female", "Alderaan", "Human"));
        characters.add(new Character("Han Solo", 180, 80, "Brown", "Light", "Brown", "29 BBY", "Male", "Corellia", "Human"));
        characters.add(new Character("Yoda", 66, 17, "White", "Green", "Brown", "896 BBY", "Male", "Unknown", "Yoda's species"));
        characters.add(new Character("Obi-Wan Kenobi", 182, 77, "Auburn", "Fair", "Blue", "57 BBY", "Male", "Stewjon", "Human"));
        characters.add(new Character("Padmé Amidala", 165, 45, "Brown", "Light", "Brown", "46 BBY", "Female", "Naboo", "Human"));
        characters.add(new Character("Chewbacca", 228, 112, "Brown", "Brown", "Blue", "200 BBY", "Male", "Kashyyyk", "Wookiee"));
    }

    public List<CharacterDTO> searchCharacters(String keyword) {
        List<CharacterDTO> results = new ArrayList<>();
        for (Character character : characters) {
            if (character.getName().toLowerCase().contains(keyword.toLowerCase())) {
                CharacterDTO dto = convertToDTO(character);
                results.add(dto);
            }
        }
        return results;
    }

    private CharacterDTO convertToDTO(Character character) {
        return new CharacterDTO(
                character.getName(),
                character.getHeight(),
                character.getMass(),
                character.getGender(),
                character.getHomeworld(),
                character.getSpecies()
        );
    }
}

