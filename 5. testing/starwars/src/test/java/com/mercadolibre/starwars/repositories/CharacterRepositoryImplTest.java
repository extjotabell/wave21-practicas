package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl _characterRepositoryImpl;

    @BeforeEach
    void setUP(){
        _characterRepositoryImpl = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("US0001 - Camino Feliz :D")
    void findTestOk() {

        //Arrange
        String query = "Luke";
        List<CharacterDTO> expectedResult = Arrays.asList(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
        );

        //Act
        List<CharacterDTO> result = _characterRepositoryImpl.findAllByNameContains(query);

        //Assert
        assertEquals(expectedResult,result);

    }

    @Test
    @DisplayName("US0002 - Camino No Feliz")
    void findTestFail() {

        //Arrange
        String query = "Luke";
        List<CharacterDTO> expectedResult = new ArrayList<>();

        //Act
        List<CharacterDTO> result = _characterRepositoryImpl.findAllByNameContains(query);

        //Assert
        assertTrue(result.isEmpty());

    }

}
