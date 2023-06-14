package com.mercadolibre.starwars.unitary;

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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    @DisplayName("FindController - Finding Character Test")
    void findCharacter(){
        // Arrange
        String query = "Luke Skywalker";
        CharacterDTO expect = new CharacterDTO();
        expect.setName("Luke Skywalker");
        expect.setHair_color("blond");
        expect.setSkin_color("fair");
        expect.setEye_color("blue");
        expect.setBirth_year("19BBY");
        expect.setGender("male");
        expect.setHomeworld("Tatooine");
        expect.setSpecies("Human");

        // Mock
        Mockito.when(controller.find(query))
                .thenReturn(List.of(expect));

        // Act
        List<CharacterDTO> result = controller.find(query);

        // Assert
        assertArrayEquals(List.of(expect).toArray(), result.toArray());
    }

    @Test
    @DisplayName("FindController - Can't find Character Test")
    void cannotFindCharacter(){
        // Arrange
        String query = "NOT";
        // Mock
        Mockito.when(controller.find(query))
                .thenReturn(new ArrayList<>());
        // Act
        List<CharacterDTO> result = controller.find(query);
        // Assert
        assertArrayEquals(new ArrayList().toArray(), result.toArray());
    }

}
