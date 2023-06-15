package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Spy
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    public void findTest(){
        //Arrange
        String query = "test";
        List<CharacterDTO> characters = List.of(new CharacterDTO());

        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(characters);

        //Act
        List<CharacterDTO> result = findService.find(query);

        //Assert
        Assertions.assertEquals(characters, result);
    }
}
