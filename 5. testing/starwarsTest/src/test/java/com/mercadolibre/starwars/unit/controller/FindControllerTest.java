package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void testFind() {

        // Arrange
        String query = "Skywalker";
        List<CharacterDTO> expectedResult = Arrays.asList(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77),
                new CharacterDTO("Anakin Skywalker", "blond", "fair", "blue", "41.9BBY", "male", "Tatooine", "Human", 188, 84),
                new CharacterDTO("Shmi Skywalker", "black", "fair", "brown", "72BBY", "female", "Tatooine", "Human", 163, null)
        );

        when(findService.find(query)).thenReturn(expectedResult);

        // Act
        List<CharacterDTO> result = findController.find(query);

        // Assert

        assertEquals(expectedResult, result);

    }

    @Test
    void testFindEmpty() {

        // Arrange
        String query = "Zkywalker";
        List<CharacterDTO> expectedResult = new ArrayList<>();

        when(findService.find(query)).thenReturn(expectedResult);

        // Act
        List<CharacterDTO> result = findController.find(query);

        // Assert

        assertEquals(expectedResult, result);

    }

}
