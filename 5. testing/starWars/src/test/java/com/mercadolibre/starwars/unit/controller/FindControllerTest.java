package com.mercadolibre.starwars.unit.controller;


import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
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
public class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

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

        // Mock
        Mockito
                .when(findService.find(findQuery))
                .thenReturn(List.of(character));

        // Act
        List<CharacterDTO> results = findController.find(findQuery);

        // Assert
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals("Charlie", results.get(0).getName()); // Just to test this.
        Assertions.assertArrayEquals(List.of(character).toArray(), results.toArray());
    }



    @Test
    @DisplayName("Test 002 - Validate empty character list.")
    void findEmptyList(){
        // Arrange
        String findQuery = "Charlie";

        // Mock
        Mockito
                .when(findService.find(findQuery))
                .thenReturn(List.of());

        // Act
        List<CharacterDTO> results = findController.find(findQuery);

        // Assert
        Assertions.assertEquals(0, results.size());
    }
}
