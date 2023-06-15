package com.mercadolibre.starwars.unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {
    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    CharacterRepositoryImpl characterRepositoryImpl;

    @Test
    @DisplayName("Test 001 - Validate character existence.")
    void findCharacter(){
        // Arrange
        String findQuery = "Charlie";
        CharacterDTO character = new CharacterDTO();
        character.setName("Charlie");
        character.setHeight(172);
        character.setMass(77);
        character.setHair_color("blond");
        character.setSkin_color("fair");
        character.setEye_color("blue");
        character.setBirth_year("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");

        // Mockito
        Mockito
                .when(characterRepository.findAllByNameContains(findQuery))
                .thenReturn(List.of(character));

        // Act
        characterRepository.findAllByNameContains(findQuery);

        // Assert
        Assertions.assertEquals(1, characterRepository.findAllByNameContains(findQuery).size());
        Assertions.assertEquals("Charlie", characterRepository.findAllByNameContains(findQuery).get(0).getName());
    }

    @Test
    @DisplayName("Test 002 - Validate empty character list.")
    void findEmptyList(){
        // Arrange
        String findQuery = Mockito.anyString();

        // Act
        characterRepository.findAllByNameContains("NOT_FOUND");

        // Assert
        Assertions.assertEquals(0, characterRepository.findAllByNameContains(findQuery).size());
    }

    @Test
    @DisplayName("Test 003 - matchWith CharacterDTO.")
    void matchWithCharacterDTO(){
        // Arrange
        String findQuery = "C-3PO";
        CharacterDTO character = new CharacterDTO();
        character.setName("C-3PO");
        character.setHeight(172);
        character.setMass(77);
        character.setHair_color("blond");
        character.setSkin_color("fair");
        character.setEye_color("blue");
        character.setBirth_year("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");

        // Mockito
        Mockito
                .when(characterRepository.findAllByNameContains(findQuery))
                .thenReturn(List.of(character));
        //Act
        List<CharacterDTO> results = characterRepository.findAllByNameContains(findQuery);

        //Assert
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals("C-3PO", results.get(0).getName());
        Assertions.assertArrayEquals(List.of(character).toArray(), results.toArray());
    }
}
