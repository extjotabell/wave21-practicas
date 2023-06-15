package com.mercadolibre.starwars.unit.repository;

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
public class CharacterRepositoryTest {

    @Mock
    CharacterRepository characterRepository;

    @Test
    @DisplayName("findAllByNameContains OK Unit Test")
    void findAllByNameContainsTest(){
        String toFind = "Luke";

        CharacterDTO characterDTO = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue",
                "19BBY", "male", "Tatooine", "Human", 172, 77);

        Mockito.when(characterRepository.findAllByNameContains(toFind))
                .thenReturn(List.of(characterDTO));

        List<CharacterDTO> result = characterRepository.findAllByNameContains(toFind);

        Assertions.assertEquals(List.of(characterDTO), result);
    }


    @Test
    @DisplayName("CharacterRepository - Cannot find Character")
    void cannotFindAllByNameContains(){
        //Arrange
        String query = "";
        //Mock
        Mockito.when(characterRepository.findAllByNameContains(query))
                .thenReturn(new ArrayList<>());
        //Act
        List<CharacterDTO> characterFound = characterRepository.findAllByNameContains(query);
        //Assert
        Assertions.assertArrayEquals(new ArrayList().toArray(),characterFound.toArray());
    }
}
