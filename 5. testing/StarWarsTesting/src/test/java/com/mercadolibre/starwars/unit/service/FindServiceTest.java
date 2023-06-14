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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("FindTest OK Unit Test")
    void findTestOk(){
        //Arrange
        String toFind = "Luke";

        CharacterDTO expect = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue",
                "19BBY", "male", "Tatooine", "Human", 172, 77);

        Mockito.when(characterRepository.findAllByNameContains(toFind))
                .thenReturn(List.of(expect));
        //Act
        List<CharacterDTO> result = findService.find(toFind);

        //Assert
        Assertions.assertEquals(List.of(expect), result);
    }

    @Test
    @DisplayName("FindTest Fail Integration Test")
    void findTestFail(){
        //Arrange
        String toFind = "404";

        Mockito
                .when(characterRepository.findAllByNameContains(toFind))
                .thenReturn(new ArrayList<>());
        // Act
        List<CharacterDTO> results = findService.find(toFind);
        // Assert
        Assertions.assertEquals(new ArrayList(), results);
    }
}
