package com.mercadolibre.starwars.unitary;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {
    @Mock
    CharacterRepositoryImpl characterRepository;

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

    @Test
    @DisplayName("CharacterRepository - Find Character")
    void findAllByNameContains(){
        //Arrange
        String query="Organa";
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
        Mockito.when(characterRepository.findAllByNameContains(query))
                .thenReturn(List.of(leia));
        //Act
        List<CharacterDTO> characterFound = characterRepository.findAllByNameContains(query);
        //Assert
        Assertions.assertArrayEquals(List.of(leia).toArray(), characterFound.toArray());
    }
}
