package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Compruebo que me envie Darth Vader cuando le paso 'Dar' por parametro.")
    public void findOk(){
        // ARRANGE
        String query = "Dar";

        CharacterDTO characterExpected = new CharacterDTO(
                "Darth Vader",
                "none",
                "white",
                "yellow",
                "41.9BBY",
                "male",
                "Tatooine",
                "Human",
                202,
                136
        );

        //MOCK
        Mockito
                .when(characterRepository.findAllByNameContains(query))
                .thenReturn(List.of(characterExpected));

        // ACT
        List<CharacterDTO> result = findService.find(query);

        // ASSERT
        Assertions.assertArrayEquals(List.of(characterExpected).toArray(), result.toArray());
    }

    @Test
    @DisplayName("Compruebo que envie una lista vacia si no encuentra nada.")
    public void findNoOk(){
        //ARRANGE
        String query = "Darlkmasdf";
        //MOCK
        Mockito
                .when(characterRepository.findAllByNameContains(query))
                .thenReturn(List.of());

        // ACT
        List<CharacterDTO> result = findService.find(query);

        // ASSERT
        Assertions.assertArrayEquals(List.of().toArray(), result.toArray());
    }
}
