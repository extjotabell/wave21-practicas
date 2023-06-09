package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CharacterRepositoryTest {

    @Mock
    FindService findService;

    @InjectMocks
    CharacterRepositoryImpl characterRepository;

    @Test
    public void testFindAllByNameContainsOk(){

        // Arrange
        String query = "Skywalker";
        List<CharacterDTO> expectedResult = Arrays.asList(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77),
                new CharacterDTO("Anakin Skywalker", "blond", "fair", "blue", "41.9BBY", "male", "Tatooine", "Human", 188, 84),
                new CharacterDTO("Shmi Skywalker", "black", "fair", "brown", "72BBY", "female", "Tatooine", "Human", 163, null)
        );
        when(findService.find(query)).thenReturn(expectedResult);

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // Assert

        System.out.println(result);

        assertEquals(expectedResult, result);

    }

    @Test
    public void testFindAllByNameContainsNoOk(){

        // Arrange
        String query = "Darth Bader";

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // Assert

        assertTrue(result.isEmpty());

    }

}
