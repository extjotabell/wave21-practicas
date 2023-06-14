package com.mercadolibre.starwars.UnitTest.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;
    @InjectMocks
    private FindService findService;

    @Test
    @DisplayName("Find happy path")
    void findHappy(){
        //Arrange
        String query = "Skywalker";
        List<CharacterDTO> expectedResult = List.of(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77),
                new CharacterDTO("Anakin Skywalker", "blond", "fair", "blue", "41.9BBY", "male", "Tatooine", "Human", 188, 84),
                new CharacterDTO("Shmi Skywalker", "black", "fair", "brown", "72BBY", "female", "Tatooine", "Human", 163, null)
        );
        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedResult);
        //Act
        List<CharacterDTO> actualResult = findService.find(query);
        //Assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("Find sad path")
    void findSad(){
        //Arrange
        String query = "Zkywalker";
        List<CharacterDTO> expectedResult = new ArrayList<>();
        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedResult);
        //Act
        List<CharacterDTO> actualResult = findService.find(query);
        //Assert
        assertEquals(expectedResult,actualResult);
    }
}