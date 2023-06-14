package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
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

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository _characterRepository;

    @InjectMocks
    FindService _findService;


    @Test
    @DisplayName("US0001 - Camino Feliz :D")
    void findTestOk() {

        //Arrange
        String query = "Luke";
        List<CharacterDTO> expectedResult = Arrays.asList(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
        );
        when(_characterRepository.findAllByNameContains(query)).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> result = _findService.find(query);

        //Assert
        assertEquals(expectedResult,result);

    }

    @Test
    @DisplayName("US0002 - Camino No Feliz")
    void findTestFail() {

        //Arrange
        String query = "Luke";
        List<CharacterDTO> expectedResult = new ArrayList<>();
        when(_characterRepository.findAllByNameContains(query)).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> result = _findService.find(query);

        //Assert
        assertTrue(result.isEmpty());

    }


}
