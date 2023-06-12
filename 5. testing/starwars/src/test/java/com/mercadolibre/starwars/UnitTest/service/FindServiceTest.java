package com.mercadolibre.starwars.UnitTest.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Find Service Test HappyPath")
    void findServiceTestOk(){
        //Arrange
        List<CharacterDTO> characterDTOList;
        //Act
        String query = "Luke";
         characterDTOList = findService.find(query);
        //Assert
        verify(characterRepository, times(1)).findAllByNameContains(query);
    }
}
