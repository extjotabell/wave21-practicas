package com.example.starwars.unit.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.model.Character;
import com.example.starwars.repository.ICharacterRepository;
import com.example.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    ICharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("buscamos algo que no existe")
    void demoService() {
        // Arrange
        String queryFind = "NOT_FOUND";
        // Mock
        Mockito
                .when(characterRepository.findAllByNameContains(queryFind))
                .thenReturn(new ArrayList<>());
        // Act
        List<CharacterDTO> results = findService.find(queryFind);
        // Assert
        Assertions.assertArrayEquals(new ArrayList().toArray(), results.toArray());
    }

    @Test
    @DisplayName("buscamos algo que existe")
    void demoService1() {
        // Arrange
        String queryFind = "find";

        String name = "Luke Skywalker";
        int height = 172;
        int mass = 77;
        String hairColor = "blond";
        String skinColor = "fair";
        String eyeColor = "blue";
        String birthYear = "19BBY";
        String gender = "male";
        String homeworld = "Tatooine";
        String species = "Human";

        Character character = new Character(name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender, homeworld, species);
        CharacterDTO expect = new CharacterDTO(name, height, mass, gender, homeworld, species);
        // Mock
        Mockito
                .when(characterRepository.findAllByNameContains(queryFind))
                .thenReturn(List.of(character));

        // Act
        List<CharacterDTO> results = findService.find(queryFind);
        // Assert
        Assertions.assertArrayEquals(List.of(expect).toArray(), results.toArray());
    }
}
