package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;


    @Test
    public void testFindOk(){

        // Arrange
        String query = "Skywalker";
        List<CharacterDTO> expectedResult = Arrays.asList(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77),
                new CharacterDTO("Anakin Skywalker", "blond", "fair", "blue", "41.9BBY", "male", "Tatooine", "Human", 188, 84),
                new CharacterDTO("Shmi Skywalker", "black", "fair", "brown", "72BBY", "female", "Tatooine", "Human", 163, null)
        );
        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedResult);

        // Act
        List<CharacterDTO> actualResult = findService.find(query);

        // Assert

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testFindNoOk(){

        // Arrange
        String query = "Zkywalker";

        List<CharacterDTO> expectedResult = new ArrayList<>();
        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedResult);

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert

        assertTrue(result.isEmpty());

    }

}
