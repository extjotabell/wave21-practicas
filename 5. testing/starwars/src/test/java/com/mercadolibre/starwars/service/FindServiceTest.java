package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void FindOk(){

        //ARRANGE
        String query = "Luke";
        CharacterDTO luke1 = new CharacterDTO("Luke Skywalker",  "blond", "fair", "blue", "19BBY",
                "male", "Tatooine", "Human",172, 77);

        List<CharacterDTO> listMock = new ArrayList<>();
        listMock.add(luke1);


        CharacterDTO luke2= new CharacterDTO("Luke Skywalker",  "blond", "fair", "blue", "19BBY",
                "male", "Tatooine", "Human",172, 77);

        List<CharacterDTO> expectedList = new ArrayList<>();
        expectedList.add(luke2);

        when(characterRepository.findAllByNameContains(any())).thenReturn(listMock);
        //ACT
        List<CharacterDTO> result = findService.find(query);
        //ASSERT
        assertEquals(expectedList, result);
    }
}
