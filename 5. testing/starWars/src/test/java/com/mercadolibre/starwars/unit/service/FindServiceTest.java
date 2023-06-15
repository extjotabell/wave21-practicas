package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Test 001 - Validate character existence.")
    void findCharacter(){
        // Arrange
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
                .when(characterRepository.findAllByNameContains(Mockito.anyString()))
                .thenReturn(List.of(character));

        // Act
        List<CharacterDTO> results = findService.find("Charlie");

        // Assert
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals("Charlie", results.get(0).getName());
        Assertions.assertEquals(172, results.get(0).getHeight());
        Assertions.assertEquals(77, results.get(0).getMass());
        Assertions.assertEquals("blond", results.get(0).getHair_color());
        Assertions.assertEquals("fair", results.get(0).getSkin_color());
        Assertions.assertEquals("blue", results.get(0).getEye_color());
        Assertions.assertEquals("19BBY", results.get(0).getBirth_year());
        Assertions.assertEquals("male", results.get(0).getGender());
        Assertions.assertEquals("Tatooine", results.get(0).getHomeworld());
        Assertions.assertEquals("Human", results.get(0).getSpecies());
        Assertions.assertArrayEquals(List.of(character).toArray(), results.toArray());
    }

    @Test
    @DisplayName("Test 002 - Validate empty character list.")
    void findEmptyList(){
        // Arrange
        String anyString = Mockito.anyString();

        // Mockito
        Mockito
                .when(characterRepository.findAllByNameContains(anyString))
                .thenReturn(new ArrayList<>());
        // Act
        List<CharacterDTO> results = findService.find("NOT_VALID_CHARACTER");

        // Assert
        Assertions.assertArrayEquals(new ArrayList<>().toArray(), results.toArray());
        Assertions.assertEquals(0, results.size());
    }
}
