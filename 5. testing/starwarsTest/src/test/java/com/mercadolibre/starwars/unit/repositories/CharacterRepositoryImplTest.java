package com.mercadolibre.starwars.unit.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository;

    @BeforeEach
    void setup(){
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void testFindOk(){

        // Arrange

        String query = "Skywalker";
        List<CharacterDTO> expectedResult = Arrays.asList(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77),
                new CharacterDTO("Anakin Skywalker", "blond", "fair", "blue", "41.9BBY", "male", "Tatooine", "Human", 188, 84),
                new CharacterDTO("Shmi Skywalker", "black", "fair", "brown", "72BBY", "female", "Tatooine", "Human", 163, null)
        );

        // Act

        List<CharacterDTO> actualResult = characterRepository.findAllByNameContains(query);

        // Assert

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testFindNoOk(){

        // Arrange
        String query = "Zkywalker";

        List<CharacterDTO> expectedResult = new ArrayList<>();

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // Assert

        assertTrue(result.isEmpty());

    }

}
