package com.mercadolibre.starwars.unitary;

import com.mercadolibre.starwars.dto.CharacterDTO;
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

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class
FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("FindService - Cannot find Character")
    void findNonExistentCharacter(){
        //Arrange
        String query = "";
        //Mock
        Mockito.when(findService.find(query))
                .thenReturn(new ArrayList<>());
        //Act
        List<CharacterDTO> characterFound = findService.find(query);
        //Assert
        Assertions.assertArrayEquals(new ArrayList().toArray(),characterFound.toArray());
    }

    @Test
    @DisplayName("FindService - Find Character")
    void findExistentCharacter(){
        //Arrange
        String query="Leia Organa";
        CharacterDTO leia = new CharacterDTO();
        leia.setName("Leia Organa");
        leia.setHeight(150);
        leia.setMass(49);
        leia.setHair_color("brown");
        leia.setSkin_color("light");
        leia.setBirth_year("19BBY");
        leia.setGender("female");
        leia.setHomeworld("Alderaan");
        leia.setSpecies("Human");
        //Mock
        Mockito.when(findService.find(query))
                .thenReturn(List.of(leia));
        //Act
        List<CharacterDTO> characterFound = findService.find(query);
        //Assert
        Assertions.assertArrayEquals(List.of(leia).toArray(), characterFound.toArray());
    }
}
