package com.mercadolibre.starwars.controller.unitary;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
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
public class FindControllerTestUnit {

    @Mock
    FindService _findService;

    @InjectMocks
    FindController _findController;

    @Test
    @DisplayName("US0001 - Camino Feliz :D")
    void findTestOk() {

        //Arrange
        String query = "Luke";
        List<CharacterDTO> expectedResult = Arrays.asList(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
        );
        when(_findService.find(query)).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> result = _findController.find(query);

        //Assert
        assertEquals(expectedResult,result);

    }

    @Test
    @DisplayName("US0002 - Camino No Feliz")
    void findTestFail() {

        //Arrange
        String query = "Luke";
        List<CharacterDTO> expectedResult = new ArrayList<>();
        when(_findService.find(query)).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> result = _findController.find(query);

        //Assert
        assertTrue(result.isEmpty());

    }

}
