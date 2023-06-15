package com.starwars.starwars.Unit.Controller;

import com.starwars.starwars.controller.FindController;
import com.starwars.starwars.dto.CharacterDTO;
import com.starwars.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService findService;

    @InjectMocks
    private FindController controller;

    @Test
    public void testFind(){
        String query = "Skywalker";

        CharacterDTO character1 = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        CharacterDTO character2 = new CharacterDTO("Anakin Skywalker", "blond", "fair", "blue", "41.9BBY", "male", "Tatooine", "Human", 188, 84);
        CharacterDTO character3 = new CharacterDTO("Shmi Skywalker", "black", "fair", "brown", "72BBY", "female", "Tatooine", "Human", 163, 90);

        List<CharacterDTO> listMock = Arrays.asList(character1, character2, character3);

        when(findService.find(query)).thenReturn(listMock);

        List<CharacterDTO> result = controller.find(query);

        assertEquals(listMock, result);
        assertNotNull(result);
    }
}
