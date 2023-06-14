package com.mercadolibre.starwars.UnitTest;

import com.mercadolibre.starwars.dto.CharacterDTO;

import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {
    CharacterRepositoryImpl repository;
    @BeforeEach
    void setup(){
        repository = new CharacterRepositoryImpl();
    }
    @Test
    @DisplayName("FindAllByNameContains happy path")
    void findAllByNameContainsHappy(){
        //Arrange
        String query = "Skywalker";
        List<CharacterDTO> expectedResult = List.of(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77),
                new CharacterDTO("Anakin Skywalker", "blond", "fair", "blue", "41.9BBY", "male", "Tatooine", "Human", 188, 84),
                new CharacterDTO("Shmi Skywalker", "black", "fair", "brown", "72BBY", "female", "Tatooine", "Human", 163, null)
        );
        //Act
        List<CharacterDTO> actualResult = repository.findAllByNameContains(query);
        //Assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @DisplayName("FindAllByNameContains sad path")
    void findAllByNameContainsSad(){
        //Arrange
        String query = "Zkywalker";
        List<CharacterDTO> expectedResult = new ArrayList<>();
        //Act
        List<CharacterDTO> actualResult = repository.findAllByNameContains(query);
        //Assert
        assertEquals(expectedResult,actualResult);
    }
}
